package pl.dkiszka.rentalapplication.hotelbookinghistory.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
@AllArgsConstructor
@Getter
public class HotelRoomBookingDaySnapshot {
    private String id;
    private LocalDate day;
}
