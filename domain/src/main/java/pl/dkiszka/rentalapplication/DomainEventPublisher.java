package pl.dkiszka.rentalapplication;

import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
public interface DomainEventPublisher {
    void publish(ApartmentBookedEvent event);
}
