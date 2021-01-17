package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlHotelRoom {

    static SqlHotelRoom fromHotelRoom(HotelRoom hotelRoom) {
        var sqlSpaces = hotelRoom.getSpaces()
                .stream()
                .map(SqlSpace::fromSpace)
                .collect(toList());
        return new SqlHotelRoom(hotelRoom.getId(), hotelRoom.getHotelId(), hotelRoom.getNumber(), sqlSpaces, hotelRoom.getDescription());
    }

    @Id
    @GeneratedValue
    private String id;
    private String hotelId;
    private int number;

    @OneToMany
    private List<SqlSpace> spaces;
    private String description;

    HotelRoom toHotelRoom() {
        var hotelRoomSpeces = spaces.stream()
                .map(SqlSpace::toSpace)
                .collect(toList());

        return new HotelRoom(id, hotelId, number, hotelRoomSpeces, description);
    }
}
