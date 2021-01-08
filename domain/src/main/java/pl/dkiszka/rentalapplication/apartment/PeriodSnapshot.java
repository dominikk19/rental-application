package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
class PeriodSnapshot {
    private LocalDate start;
    private LocalDate end;
}
