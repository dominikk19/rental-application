package pl.dkiszka.rentalapplication.hotelroom;

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
class SqlHotelRoom {

    static SqlHotelRoom fromHotelRoom(HotelRoom hotelRoom) {
        var hotelRoomSnapsot = hotelRoom.getSnapshot();
        var sqlSpaces = hotelRoomSnapsot.getSpaces()
                .stream()
                .map(SqlSpace::fromSpace)
                .collect(toList());
        return new SqlHotelRoom(hotelRoomSnapsot.getId(),
                hotelRoomSnapsot.getHotelId(),
                hotelRoomSnapsot.getNumber(),
                sqlSpaces,
                hotelRoomSnapsot.getDescription(),
                hotelRoomSnapsot.getBookings());
    }

    @Id
    @GeneratedValue
    private String id;
    private String hotelId;
    private int number;

    @OneToMany
    private final Set<SqlSpace> spaces = Sets.newHashSet();

    private String description;

    @OneToMany
    private final Set<SimpleBooking> bookings = Sets.newHashSet();

    public SqlHotelRoom(String id, String hotelId, int number, List<SqlSpace> spaces, String description, List<SimpleBooking> bookings) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
        this.spaces.addAll(spaces);
        this.description = description;
        bookings.stream()
                .map(it -> new SimpleBooking(it.getId()))
                .forEach(this.bookings::add);
    }

    HotelRoom toHotelRoom() {
        var hotelRoomSpeces = spaces.stream()
                .map(SqlSpace::toSpace)
                .collect(toList());

        return new HotelRoom(id,
                hotelId,
                number,
                hotelRoomSpeces,
                description,
                Lists.newArrayList(bookings));
    }
}
