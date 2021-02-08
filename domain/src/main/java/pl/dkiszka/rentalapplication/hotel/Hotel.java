package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Hotel {

    static Hotel restore(HotelSnapshot snapshot) {
        var rooms = snapshot.getRooms()
                .stream()
                .map(Room::restore)
                .collect(toList());

        return new Hotel(snapshot.getId(),
                snapshot.getName(),
                Address.restore(snapshot.getAddress()),
                rooms
        );
    }


    private final String id;
    private final String name;
    private final Address address;
    private final List<Room> rooms;

    void addRoom(Room room) {
        this.rooms.add(room);
    }


    HotelSnapshot toSnapshot() {
        return new HotelSnapshot(id, name, address.toSnapshot(),
                rooms.stream()
                        .map(Room::toSnapshot)
                        .collect(toList()));
    }

    Room roomByRoomId(String roomId) {
        return this.rooms.stream()
                .map(Room::toSnapshot)
                .filter(room -> room.getId().equals(roomId))
                .findFirst()
                .map(Room::restore)
                .orElseThrow(() -> new RoomNotFoundException(String.format("Room by Id %s not found", roomId)));
    }

}
