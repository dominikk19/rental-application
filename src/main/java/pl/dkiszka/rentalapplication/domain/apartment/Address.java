package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.AddressDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
public class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;

    public static Address fromDto(AddressDto address) {
        return new Address(address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getPostalCode(),
                address.getHouseNumber(),
                address.getApartmentNumber());
    }
}
