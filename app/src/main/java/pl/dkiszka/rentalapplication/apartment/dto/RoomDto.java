package pl.dkiszka.rentalapplication.apartment.dto;

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
    private final String id;
    private final String name;
    private final Double size;

}
