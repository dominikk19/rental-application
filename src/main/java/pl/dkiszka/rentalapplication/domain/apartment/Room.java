package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.RoomDto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
@Entity
class Room {
    @Id
    @GeneratedValue
    private String id;

    private final String name;

    @Embedded
    private final SquareMater size;

    static Room fromDto(RoomDto room) {
        return new Room(room.getName(), new SquareMater(room.getSize()));
    }
}
