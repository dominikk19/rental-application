package pl.dkiszka.rentalapplication.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@AllArgsConstructor
@Getter
public class RoomDto {

    private String id;
    private int number;
    private List<SpaceDto> spaces;
    private String description;
}
