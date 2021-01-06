package pl.dkiszka.rentalapplication.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@AllArgsConstructor
@Getter
@Builder
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String buildingNumber;
}
