package pl.dkiszka.rentalapplication.apartment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class ApartmentDto {
    private final String id;
    private final AddressDto address;
    private final List<RoomDto> rooms;
    private final String description;


}
