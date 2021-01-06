package pl.dkiszka.rentalapplication.hotelroom;

import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class HotelRoomFactory {
    public HotelRoom create(HotelRoomDto hotelRoom) {
        var speces = hotelRoom.getSpaces()
                .stream()
                .map(spec -> {
                    var sq = new SquareMater(spec.getSize());
                    return new Space(spec.getId(), spec.getName(), sq);
                })
                .collect(toList());

        return new HotelRoom(hotelRoom.getId(),
                hotelRoom.getHotelId(),
                hotelRoom.getNumber(),
                speces,
                hotelRoom.getDescription());
    }
}
