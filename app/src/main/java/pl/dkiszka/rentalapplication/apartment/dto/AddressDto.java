package pl.dkiszka.rentalapplication.apartment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
@Setter
public class AddressDto {
    private String id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;

    public void setId(String id) {
        this.id = id;
    }
}
