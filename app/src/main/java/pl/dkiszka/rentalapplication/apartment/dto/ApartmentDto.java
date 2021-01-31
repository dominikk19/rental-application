package pl.dkiszka.rentalapplication.apartment.dto;

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
    private final String uuid;
    private final String ownerId;
    private final AddressDto address;
    private final List<RoomDto> rooms;
    private final String description;

}
