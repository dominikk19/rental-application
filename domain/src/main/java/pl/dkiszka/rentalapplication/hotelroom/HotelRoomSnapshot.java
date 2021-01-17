package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
class HotelRoomSnapshot {
    private String id;
    private String hotelId;
    private int number;
    private List<SpaceSnapshot> spaces;
    private String description;
    private final List<SimpleBooking> bookings;
}
