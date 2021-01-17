package pl.dkiszka.rentalapplication.hotelroom;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;
import pl.dkiszka.rentalapplication.hotelroom.vo.HotelRoomBookedEvent;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class HotelRoom {

    static HotelRoom restore(HotelRoomSnapshot hotelRoomSnapshot) {
        return new HotelRoom(hotelRoomSnapshot.getId(),
                hotelRoomSnapshot.getHotelId(),
                hotelRoomSnapshot.getNumber(),
                hotelRoomSnapshot.getSpaces().stream().map(Space::restore).collect(toList()),
                hotelRoomSnapshot.getDescription(),
                hotelRoomSnapshot.getBookings());
    }

    private final String id;
    private final String hotelId;
    private final int number;
    private final List<Space> spaces = Lists.newArrayList();
    private final String description;
    private final List<SimpleBooking> bookings = Lists.newArrayList();

    public HotelRoom(String id, String hotelId, int number, List<Space> spaces, String description, List<SimpleBooking> bookings) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.spaces.addAll(spaces);
        this.bookings.addAll(bookings);
    }

    HotelRoomSnapshot getSnapshot() {
        return new HotelRoomSnapshot(id, hotelId, number,
                spaces.stream().map(Space::getSnapsot).collect(toList()),
                description,
                bookings);
    }

    HotelRoom addBooking(SimpleBooking booking) {
        bookings.add(booking);
        return this;
    }

    HotelRoomBookedEvent bookedEvent(String tenantId, List<LocalDate> days) {
        return HotelRoomBookedEvent.create(hotelId, id, tenantId, days);
    }
}
