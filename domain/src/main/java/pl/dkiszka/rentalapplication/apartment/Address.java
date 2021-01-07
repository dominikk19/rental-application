package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
class Address {

    static Address restore(AddressSnapshot addressSnapshot) {
        return Address.builder()
                .country(addressSnapshot.getCountry())
                .city(addressSnapshot.getCity())
                .street(addressSnapshot.getStreet())
                .postalCode(addressSnapshot.getPostalCode())
                .houseNumber(addressSnapshot.getHouseNumber())
                .apartmentNumber(addressSnapshot.getApartmentNumber())
                .build();
    }

    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;

    AddressSnapshot getSnapshot() {
        return AddressSnapshot.builder()
                .country(country)
                .city(city)
                .street(street)
                .postalCode(postalCode)
                .houseNumber(houseNumber)
                .apartmentNumber(apartmentNumber)
                .build();
    }

}
