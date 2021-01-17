package pl.dkiszka.rentalapplication.booking;

import org.apache.logging.log4j.util.Strings;
import pl.dkiszka.rentalapplication.booking.vo.BookingAcceptedEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
class Booking {

    static Booking restore(BookingSnapshot snapshot) {
        return new Booking(snapshot.getId(),
                snapshot.getUuid(),
                snapshot.getRentalType(),
                snapshot.getRentalPlaceId(),
                snapshot.getTenantId(),
                snapshot.getDays().stream().map(BookingDay::restore).collect(toList()),
                snapshot.getBookingStatus()
        );
    }

    static Booking apartment(String apartmentId, String tenantId, List<LocalDate> days) {
        return new Booking(Strings.EMPTY,
                UUID.randomUUID().toString(),
                RentalType.APARTMENT,
                apartmentId,
                tenantId,
                days.stream().map(it -> BookingDay.restore(BookingDaySnapshot.create(it))).collect(toList()),
                BookingStatus.OPEN
        );
    }

    static Booking hotelRoom(String hotelRoomId, String tenantId, List<LocalDate> days) {
        return new Booking(Strings.EMPTY,
                UUID.randomUUID().toString(),
                RentalType.HOTEL_ROOM,
                hotelRoomId,
                tenantId,
                days.stream().map(it -> BookingDay.restore(BookingDaySnapshot.create(it))).collect(toList()),
                BookingStatus.OPEN
        );
    }

    private final String id;
    private final String uuid;
    private final RentalType rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<BookingDay> days;
    private BookingStatus bookingStatus;

    public Booking(String id, String uuid, RentalType rentalType, String rentalPlaceId, String tenantId,
                   List<BookingDay> days, BookingStatus bookingStatus) {
        this.id = id;
        this.uuid = uuid;
        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = days;
        this.bookingStatus = bookingStatus;
    }

    BookingSnapshot getSnapshot() {
        return new BookingSnapshot(id,
                uuid,
                rentalPlaceId,
                rentalType,
                tenantId,
                days.stream()
                        .map(BookingDay::getSnapshot)
                        .collect(toList()),
                bookingStatus);
    }


    Booking reject() {
        bookingStatus = BookingStatus.REJECT;
        return this;
    }

    BookingAcceptedEvent accept() {
        bookingStatus = BookingStatus.ACCEPT;
        var bookingDays = days.stream().map(BookingDay::getSnapshot)
                .map(BookingDaySnapshot::getDay)
                .collect(toList());
        return BookingAcceptedEvent.create(rentalType.name(), rentalPlaceId, tenantId, bookingDays);
    }
}
