package pl.dkiszka.rentalapplication.hotel;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;
import pl.dkiszka.rentalapplication.hotel.vo.HotelRoomBookedEvent;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class Room {

    static Room restore(RoomSnapshot roomSnapshot) {
        return new Room(roomSnapshot.getId(),
                roomSnapshot.getNumber(),
                roomSnapshot.getSpaces().stream().map(Space::restore).collect(toList()),
                roomSnapshot.getDescription(),
                roomSnapshot.getBookings());
    }

    private final String id;
    private final int number;
    private final List<Space> spaces = Lists.newArrayList();
    private final String description;
    private final List<SimpleBooking> bookings = Lists.newArrayList();

    public Room(String id, int number, List<Space> spaces, String description, List<SimpleBooking> bookings) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.spaces.addAll(spaces);
        this.bookings.addAll(bookings);
    }

    RoomSnapshot toSnapshot() {
        return new RoomSnapshot(id, number,
                spaces.stream().map(Space::getSnapsot).collect(toList()),
                description,
                bookings);
    }

    Room addBooking(SimpleBooking booking) {
        bookings.add(booking);
        return this;
    }

    HotelRoomBookedEvent bookedEvent(String hotelId, String tenantId, List<LocalDate> days) {
        return HotelRoomBookedEvent.create(hotelId, id, tenantId, days);
    }
}
