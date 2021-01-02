package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.AddressDto;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter(AccessLevel.PACKAGE)
@Embeddable
class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;

    static Address fromDto(AddressDto address) {
        return new Address(address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getPostalCode(),
                address.getHouseNumber(),
                address.getApartmentNumber());
    }
}
