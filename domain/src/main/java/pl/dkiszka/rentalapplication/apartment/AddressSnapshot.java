package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class AddressSnapshot {
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;
}
