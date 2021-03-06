package pl.dkiszka.rentalapplication.hotel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 05.01.2021
 */
interface HotelRepository {
    Hotel save(Hotel hotel);

    Hotel findById(String hotelId);
}
