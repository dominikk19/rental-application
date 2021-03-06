package pl.dkiszka.rentalapplication.hotelbookinghistory.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */

@AllArgsConstructor
@Getter
public class HotelBookingHistorySnapshot {
    private String hotelId;
    private List<HotelRoomBookingHistorySnapshot> hotelRoomBookingHistories;
}
