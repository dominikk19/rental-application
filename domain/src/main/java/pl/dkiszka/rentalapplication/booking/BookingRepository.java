package pl.dkiszka.rentalapplication.booking;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
interface BookingRepository {
    Booking save(Booking booking);

    Optional<Booking> findById(String id);
}
