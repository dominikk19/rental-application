package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
class SqlApartmentBookingHistory {

    static SqlApartmentBookingHistory from(ApartmentBookingHistory apartmentBookingHistory) {
        var snapshot = apartmentBookingHistory.getSnapshot();
        var bookings = snapshot.getBookings()
                .stream()
                .map(SqlApartmentBooking::from)
                .collect(toSet());

        return new SqlApartmentBookingHistory(snapshot.getId(), snapshot.getApartmentUuid(), bookings);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String apartmentUuid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_booking_history_id")
    private final Set<SqlApartmentBooking> bookings = Sets.newHashSet();

    SqlApartmentBookingHistory(String id, String uuid, Set<SqlApartmentBooking> bookings) {
        this.id = id;
        this.apartmentUuid = uuid;
        this.bookings.addAll(bookings);
    }

    ApartmentBookingHistory toApartmentBookingHistory() {
        var apartmentBookings = bookings.stream()
                .map(SqlApartmentBooking::toApartmentBooking)
                .collect(toList());
        return ApartmentBookingHistory.restore(
                new ApartmentBookingHistorySnapshot(id, apartmentUuid, apartmentBookings));
    }

    @Entity
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter(AccessLevel.PACKAGE)
    static class SqlApartmentBooking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        private String uuid;
        private LocalDateTime bookingDataTime;
        private BookingStep bookingStep;
        private String ownerId;
        private String tenantId;
        private LocalDate periodStart;
        private LocalDate periodEnd;

        static SqlApartmentBooking from(ApartmentBookingSnapshot snapshot) {
            return new SqlApartmentBooking(snapshot.getId(),
                    snapshot.getUuid(),
                    snapshot.getBookingDataTime(),
                    snapshot.getBookingStep(),
                    snapshot.getOwnerId(),
                    snapshot.getTenantId(),
                    snapshot.getPeriodStart(),
                    snapshot.getPeriodEnd());
        }


        ApartmentBookingSnapshot toApartmentBooking() {
            return new ApartmentBookingSnapshot(id, uuid, bookingDataTime, bookingStep, ownerId, tenantId, periodStart, periodEnd);
        }
    }
}
