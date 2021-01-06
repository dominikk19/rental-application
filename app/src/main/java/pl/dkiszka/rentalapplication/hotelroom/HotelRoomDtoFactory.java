package pl.dkiszka.rentalapplication.hotelroom;

import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomDto;
import pl.dkiszka.rentalapplication.hotelroom.dto.SpaceDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
class HotelRoomDtoFactory {

    static HotelRoomDto fromHotelRoom(HotelRoom hotelRoom) {
        var speces = hotelRoom.getSpaces()
                .stream()
                .map(HotelRoomDtoFactory::fromSpec)
                .collect(toList());
        return new HotelRoomDto(hotelRoom.getId(),
                hotelRoom.getHotelId(),
                hotelRoom.getNumber(),
                speces,
                hotelRoom.getDescription());
    }

    private static SpaceDto fromSpec(Space space) {
        return new SpaceDto(space.getId(), space.getName(), space.getSquareMater().getSize());
    }
}
