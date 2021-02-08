package pl.dkiszka.rentalapplication.hotel;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlAddress {

    static SqlAddress fromAddress(AddressSnapshot address) {
        return new SqlAddress(
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getPostalCode(),
                address.getBuildingNumber());
    }

    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String buildingNumber;

    AddressSnapshot toAddress() {
        return new AddressSnapshot(country, city, street, postalCode, buildingNumber);
    }
}
