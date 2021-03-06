package pl.dkiszka.rentalapplication.hotel;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.hotel.dto.RoomDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class HotelRoomFactory {
    public Room create(RoomDto hotelRoom) {
        var speces = hotelRoom.getSpaces()
                .stream()
                .map(spec -> {
                    var sq = new SquareMaterSnapshot(spec.getSize());
                    return Space.restore(new SpaceSnapshot(spec.getId(), spec.getName(), sq));
                })
                .collect(toList());

        return new Room(hotelRoom.getId(),
                hotelRoom.getNumber(),
                speces,
                hotelRoom.getDescription(),
                Lists.newArrayList());
    }
}
