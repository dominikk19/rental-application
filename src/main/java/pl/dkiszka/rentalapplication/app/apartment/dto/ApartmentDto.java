package pl.dkiszka.rentalapplication.app.apartment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
public class ApartmentDto {
    private final AddressDto address;
    private List<RoomDto> rooms;
    private String description;
}
