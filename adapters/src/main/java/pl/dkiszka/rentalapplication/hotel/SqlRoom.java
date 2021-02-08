package pl.dkiszka.rentalapplication.hotel;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlRoom {

    static SqlRoom fromHotelRoom(Room room) {
        var hotelRoomSnapsot = room.toSnapshot();
        var sqlSpaces = hotelRoomSnapsot.getSpaces()
                .stream()
                .map(SqlSpace::fromSpace)
                .collect(toList());
        return new SqlRoom(hotelRoomSnapsot.getId(),
                hotelRoomSnapsot.getNumber(),
                sqlSpaces,
                hotelRoomSnapsot.getDescription(),
                hotelRoomSnapsot.getBookings());
    }

    @Id
    @GeneratedValue
    private String id;
    private int number;

    @OneToMany
    private final Set<SqlSpace> spaces = Sets.newHashSet();

    private String description;

    @OneToMany
    private final Set<SqlSimpleBooking> bookings = Sets.newHashSet();

    public SqlRoom(String id, int number, List<SqlSpace> spaces, String description, List<SimpleBooking> bookings) {
        this.id = id;
        this.number = number;
        this.spaces.addAll(spaces);
        this.description = description;
        bookings.stream()
                .map(sm -> new SqlSimpleBooking(sm.getId()))
                .forEach(this.bookings::add);
    }

    RoomSnapshot toHotelRoom() {
        var hotelRoomSpeces = spaces.stream()
                .map(SqlSpace::toSpace)
                .collect(toList());

        var bookingsSnapshot = bookings.stream()
                .map(SqlSimpleBooking::toSimpleBooking)
                .collect(toList());

        return new RoomSnapshot(id,
                number,
                hotelRoomSpeces,
                description,
                bookingsSnapshot);
    }
}
