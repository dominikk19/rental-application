package pl.dkiszka.rentalapplication.booking;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
interface BookingRepository {
    Booking save(Booking booking);
}
