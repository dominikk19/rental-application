package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Period {
    static Period restore(PeriodSnapshot periodSnapshot) {
        return new Period(periodSnapshot.getStart(), periodSnapshot.getEnd());
    }

    private final LocalDate start;
    private final LocalDate end;

    PeriodSnapshot getSnapshot() {
        return new PeriodSnapshot(start, end);
    }
}
