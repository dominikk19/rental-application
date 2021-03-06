package pl.dkiszka.rentalapplication.eventchanel;

import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.booking.vo.BookingAcceptedEvent;
import pl.dkiszka.rentalapplication.hotel.vo.HotelRoomBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
public interface DomainEventPublisher {
    void publish(ApartmentBookedEvent event);
    void publish(HotelRoomBookedEvent event);
    void publish(BookingAcceptedEvent event);
}
