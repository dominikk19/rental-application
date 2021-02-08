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

    static Address restore(AddressSnapshot address) {
        return new Address(address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getPostalCode(),
                address.getBuildingNumber());
    }

    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String buildingNumber;


    AddressSnapshot toSnapshot() {
        return new AddressSnapshot(country,
                city,
                street,
                postalCode,
                buildingNumber);
    }
}
