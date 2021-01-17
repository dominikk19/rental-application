package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class BookingDay {
    static BookingDay restore(BookingDaySnapshot bookingDaySnapshot) {
        return new BookingDay(bookingDaySnapshot.getId(), bookingDaySnapshot.getDay());
    }

    private final String id;

    private final LocalDate day;

    BookingDaySnapshot getSnapshot() {
        return new BookingDaySnapshot(id, day);
    }
}
