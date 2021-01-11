package pl.dkiszka.rentalapplication.hotelbookinghistory;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
interface HotelBookingHistoryRepository {

    Optional<HotelBookingHistory> findByHotelId(String hotelId);

    HotelBookingHistory save(HotelBookingHistory hotelBookingHistory);
}
