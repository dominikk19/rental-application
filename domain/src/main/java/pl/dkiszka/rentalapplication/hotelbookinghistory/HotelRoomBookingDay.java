package pl.dkiszka.rentalapplication.hotelbookinghistory;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingDaySnapshot;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
@RequiredArgsConstructor
class HotelRoomBookingDay {

    static HotelRoomBookingDay restore(HotelRoomBookingDaySnapshot snapshot) {
        return new HotelRoomBookingDay(snapshot.getId(), snapshot.getDay());
    }

    private final String id;
    private final LocalDate day;

    HotelRoomBookingDaySnapshot getSnapshot() {
        return new HotelRoomBookingDaySnapshot(id, day);
    }

}
