package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.DomainEventPublisher;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Component
class SpringDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(ApartmentBookedEvent event) {

    }
}
