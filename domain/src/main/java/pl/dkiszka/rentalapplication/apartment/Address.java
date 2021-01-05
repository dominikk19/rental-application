package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
class Address {
    private final String id;
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;
}
