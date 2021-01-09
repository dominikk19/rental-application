package pl.dkiszka.rentalapplication.hotelroom;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 05.01.2021
 */
interface HotelRoomRepository {
    HotelRoom save(HotelRoom hotelRoom);

    Optional<HotelRoom> findById(String id);
}
