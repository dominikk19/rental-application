package pl.dkiszka.rentalapplication.hotel;

import pl.dkiszka.rentalapplication.hotel.dto.RoomDto;
import pl.dkiszka.rentalapplication.hotel.dto.SpaceDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
class HotelRoomDtoFactory {

    static RoomDto fromHotelRoom(RoomSnapshot room) {
        var speces = room.getSpaces()
                .stream()
                .map(HotelRoomDtoFactory::fromSpec)
                .collect(toList());
        return new RoomDto(room.getId(),
                room.getNumber(),
                speces,
                room.getDescription());
    }

    private static SpaceDto fromSpec(SpaceSnapshot space) {
        return new SpaceDto(space.getId(), space.getName(), space.getSquareMater().getSize());
    }
}
