package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 03.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
class SqlAddress {

    static SqlAddress fromAddress(Address address) {
        return new SqlAddress(address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getPostalCode(),
                address.getHouseNumber(),
                address.getApartmentNumber());
    }

    private String id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;
}
