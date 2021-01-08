package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Room {

    static Room restore(RoomSnapshot roomSnapshot) {
        return new Room(roomSnapshot.getId(), roomSnapshot.getName(), new SquareMater(roomSnapshot.getSize()));
    }

    private final String id;
    private final String name;
    private final SquareMater size;

    RoomSnapshot getSnapshot() {
        return new RoomSnapshot(id, name, size.getSize());
    }
}
