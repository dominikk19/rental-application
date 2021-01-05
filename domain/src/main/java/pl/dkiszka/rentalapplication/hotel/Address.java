package pl.dkiszka.rentalapplication.hotel;

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
class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String buildingNumber;

}
