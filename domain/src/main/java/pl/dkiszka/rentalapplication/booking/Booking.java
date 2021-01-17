package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class Booking {

    static Booking restore(BookingSnapshot snapshot) {
        return new Booking(snapshot.getId(),
                snapshot.getUuid(),
                snapshot.getRentalType(),
                snapshot.getRentalPlaceId(),
                snapshot.getTenantId(),
                snapshot.getDays().stream().map(BookingDay::restore).collect(toList()));
    }

    static Booking apartment(String apartmentId, String tenantId, List<LocalDate> days) {
        return new Booking(Strings.EMPTY,
                UUID.randomUUID().toString(),
                RentalType.APARTMENT,
                apartmentId,
                tenantId,
                days.stream().map(it -> BookingDay.restore(BookingDaySnapshot.create(it))).collect(toList()));
    }

    static Booking hotelRoom(String hotelRoomId, String tenantId, List<LocalDate> days) {
        return new Booking(Strings.EMPTY,
                UUID.randomUUID().toString(),
                RentalType.HOTEL_ROOM,
                hotelRoomId,
                tenantId,
                days.stream().map(it -> BookingDay.restore(BookingDaySnapshot.create(it))).collect(toList()));
    }

    private final String id;
    private final String uuid;
    private final RentalType rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<BookingDay> days;


    BookingSnapshot getSnapshot() {
        return new BookingSnapshot(id,
                uuid,
                rentalPlaceId,
                rentalType,
                tenantId,
                days.stream()
                        .map(BookingDay::getSnapshot)
                        .collect(toList()));
    }


}
