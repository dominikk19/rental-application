package pl.dkiszka.rentalapplication.booking;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RequiredArgsConstructor
public class BookingFacade {


    private final BookingRepository bookingRepository;

    public SimpleBooking bookApartment(String apartmentId, String tenantId, List<LocalDate> days) {
        var booking = Booking.apartment(apartmentId, tenantId, days);
        var savedBooking = bookingRepository.save(booking);
        return new SimpleBooking(savedBooking.getSnapshot().getId());
    }

    public SimpleBooking bookHotelRoom(String hotelRoomId, String tenantId, List<LocalDate> days) {
        var booking = Booking.hotelRoom(hotelRoomId, tenantId, days);
        var savedBooking = bookingRepository.save(booking);
        return new SimpleBooking(savedBooking.getSnapshot().getId());
    }


}
