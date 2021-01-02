package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Hotel {
    private final String name;
    private final Address address;

}
