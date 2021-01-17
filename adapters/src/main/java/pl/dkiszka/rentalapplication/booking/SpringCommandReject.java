package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class SpringCommandReject implements CommandRegistry {

    private final ApplicationEventPublisher publisher;

    @Override
    public void register(String id) {
        publisher.publishEvent(new BookingReject(id));
    }

    @Override
    public void accept(String id) {
        publisher.publishEvent(new BookingAccept(id));
    }
}
