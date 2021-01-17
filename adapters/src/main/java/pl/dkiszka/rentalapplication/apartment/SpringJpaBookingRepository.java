package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 15.01.2021
 */

interface SpringJpaBookingRepository extends Repository<BookingSnapshot, String> {
    BookingSnapshot save(BookingSnapshot bookingSnapshot);
}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@org.springframework.stereotype.Repository
class JpaBookingRepository implements BookingRepository {
    private final SpringJpaBookingRepository springJpaBookingRepository;

    @Override
    public Booking save(Booking booking) {
        return Booking.restore(springJpaBookingRepository.save(booking.getSnapshot()));
    }
}
