package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.02.2021
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class AddressSnapshot {
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String buildingNumber;
}
