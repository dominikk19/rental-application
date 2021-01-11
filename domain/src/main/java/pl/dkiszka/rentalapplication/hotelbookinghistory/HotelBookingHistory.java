package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelBookingHistorySnapshot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
class HotelBookingHistory {

    static HotelBookingHistory restore(HotelBookingHistorySnapshot snapshot) {
        var hotelBookingHistory = snapshot.getHotelRoomBookingHistories().stream()
                .map(HotelRoomBookingHistory::restore)
                .collect(Collectors.toList());
        return new HotelBookingHistory(snapshot.getHotelId(), hotelBookingHistory);
    }

    private final String hotelId;
    private final List<HotelRoomBookingHistory> hotelRoomBookingHistories = Lists.newArrayList();


    private HotelBookingHistory(String hotelId, List<HotelRoomBookingHistory> hotelRoomBookingHistories) {
        this.hotelId = hotelId;
        this.hotelRoomBookingHistories.addAll(hotelRoomBookingHistories);
    }

    HotelBookingHistorySnapshot getSnapshot() {
        var hotelRoom = hotelRoomBookingHistories.stream()
                .map(HotelRoomBookingHistory::getSnapshot)
                .collect(toList());
        return new HotelBookingHistorySnapshot(hotelId, hotelRoom);
    }


    void addBooking(String hotelRoomId, LocalDateTime eventCreationDataTime, String tenantId, List<LocalDate> days) {
        findHotelRoomBookingHistory(hotelRoomId)
                .ifPresent(it -> it.add(eventCreationDataTime, tenantId, days));
    }

    private Optional<HotelRoomBookingHistory> findHotelRoomBookingHistory(String hotelRoomId) {
        return hotelRoomBookingHistories.stream()
                .map(HotelRoomBookingHistory::getSnapshot)
                .filter(hrb -> hrb.getHotelRoomId().equals(hotelRoomId))
                .map(HotelRoomBookingHistory::restore)
                .findFirst();

    }
}
