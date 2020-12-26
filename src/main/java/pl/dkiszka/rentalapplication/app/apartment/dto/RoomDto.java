package pl.dkiszka.rentalapplication.app.apartment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
public class RoomDto {
    private String name;
    private Double size;


}
