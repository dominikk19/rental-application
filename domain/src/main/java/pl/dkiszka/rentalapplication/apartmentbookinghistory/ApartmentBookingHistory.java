package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
class ApartmentBookingHistory {

    static ApartmentBookingHistory restore(ApartmentBookingHistorySnapshot snapshot) {
        var bookings = snapshot.getBookings()
                .stream()
                .map(ApartmentBooking::restore)
                .collect(toList());

        return new ApartmentBookingHistory(snapshot.getId(), snapshot.getApartmentUuid(), bookings);
    }

    static ApartmentBookingHistory start(ApartmentBookedEvent apartmentBookedEvent) {
        var bookings = ApartmentBooking.start(
                apartmentBookedEvent.getOwnerId(),
                apartmentBookedEvent.getTenantId(),
                apartmentBookedEvent.getStart(),
                apartmentBookedEvent.getEnd());

        return new ApartmentBookingHistory(Strings.EMPTY, apartmentBookedEvent.getApartmentUuid(), Lists.newArrayList(bookings));
    }

    private final String id;
    private final String apartmentUuid;
    private final List<ApartmentBooking> bookings = Lists.newArrayList();

    public ApartmentBookingHistory(String id, String apartmentUuid, List<ApartmentBooking> bookings) {
        this.id = id;
        this.apartmentUuid = apartmentUuid;
        this.bookings.addAll(bookings);
    }

    ApartmentBookingHistorySnapshot getSnapshot() {
        var bookingsSnapshot = bookings.stream()
                .map(ApartmentBooking::getSnapshot)
                .collect(toList());
        return new ApartmentBookingHistorySnapshot(id, apartmentUuid, bookingsSnapshot);
    }

    void addBooking(ApartmentBooking apartmentBooking) {
        bookings.add(apartmentBooking);
    }
}
