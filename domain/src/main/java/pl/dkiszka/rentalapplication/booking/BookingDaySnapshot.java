package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class BookingDaySnapshot {

    static BookingDaySnapshot create(LocalDate day){
        return new BookingDaySnapshot(day);
    }

    private String id;
    private LocalDate day;

    private BookingDaySnapshot(LocalDate day) {
        this.day = day;
    }
}
