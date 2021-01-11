package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingHistorySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingSnapshot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
class HotelRoomBookingHistory {

    static HotelRoomBookingHistory restore(HotelRoomBookingHistorySnapshot snapshot) {
        var bookings = snapshot.getBookingsSnapshot().stream()
                .map(HotelRoomBooking::restore)
                .collect(toList());
        return new HotelRoomBookingHistory(snapshot.getHotelRoomId(), bookings);
    }

    private final String hotelRoomId;
    private final List<HotelRoomBooking> bookings = Lists.newArrayList();

    private HotelRoomBookingHistory(String hotelRoomId, List<HotelRoomBooking> bookings) {
        this.hotelRoomId = hotelRoomId;
        this.bookings.addAll(bookings);
    }

    HotelRoomBookingHistorySnapshot getSnapshot() {
        var roomBooking = bookings.stream()
                .map(HotelRoomBooking::getSnapshot)
                .collect(toList());
        return new HotelRoomBookingHistorySnapshot(hotelRoomId, roomBooking);
    }

    public void add(LocalDateTime eventCreationDataTime, String tenantId, List<LocalDate> days) {
        bookings.add(HotelRoomBooking.restore(new HotelRoomBookingSnapshot(eventCreationDataTime, tenantId, days)));
    }
}
