package pl.dkiszka.rentalapplication.common.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.hotelroom.vo.HotelRoomBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Component
public class SpringDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(ApartmentBookedEvent event) {

    }

    @Override
    public void publish(HotelRoomBookedEvent event) {

    }
}
