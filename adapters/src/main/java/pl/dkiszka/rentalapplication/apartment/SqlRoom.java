package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 03.01.2021
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SqlRoom {

    static SqlRoom fromRoom(Room room) {
        return new SqlRoom(room.getId(), room.getName(), JpaSquareMater.fromSquareMater(room.getSize()));
    }

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @Embedded
    private JpaSquareMater size;

    Room toRoom() {
        return new Room(id, name, new SquareMater(size.getSize()));
    }
}
