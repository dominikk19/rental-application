package pl.dkiszka.rentalapplication.common.events;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
public interface DomainEventPublisher {
    void publish(BookedEvent event);
}
