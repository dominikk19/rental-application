package pl.dkiszka.rentalapplication.apartment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@AllArgsConstructor
@Getter
@Builder
public class AddressDto {
    private String id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;

}
