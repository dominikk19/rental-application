package pl.dkiszka.rentalapplication.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@AllArgsConstructor
@Getter
public class SpaceDto {
    private String id;
    private String name;
    private Double size;
}
