package pl.dkiszka.rentalapplication.common.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Component
public class SpringDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(BookedEvent event) {

    }
}
