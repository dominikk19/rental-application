package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
class SquareMater {
    private final Double size;
}
