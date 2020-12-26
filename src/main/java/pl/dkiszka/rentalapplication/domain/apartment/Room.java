package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.RoomDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
public class Room {
    private final String name;
    private final SquareMater size;

    public static Room fromDto(RoomDto room) {
        return new Room(room.getName(), new SquareMater(room.getSize()));
    }
}
