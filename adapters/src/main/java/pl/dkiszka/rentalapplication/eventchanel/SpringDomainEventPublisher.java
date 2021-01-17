package pl.dkiszka.rentalapplication.eventchanel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.booking.vo.BookingAcceptedEvent;
import pl.dkiszka.rentalapplication.hotelroom.vo.HotelRoomBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Component
public class SpringDomainEventPublisher implements DomainEventPublisher {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(ApartmentBookedEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void publish(HotelRoomBookedEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void publish(BookingAcceptedEvent event) {
        publisher.publishEvent(event);
    }
}
