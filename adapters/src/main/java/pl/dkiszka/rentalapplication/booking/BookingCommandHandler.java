package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class BookingCommandHandler {
    private final BookingRepository bookingRepository;
    private final DomainEventPublisher domainEventPublisher;


    @EventListener
    public void reject(BookingReject bookingReject) {
        var booking = bookingRepository.findById(bookingReject.getBookingId());
        booking.ifPresent(it -> {
            var bookingRejected = it.reject();

            bookingRepository.save(bookingRejected);

        });
    }

    @EventListener
    public void accept(BookingAccept bookingAccept) {
        var booking = bookingRepository.findById(bookingAccept.getBookingId());
        booking.ifPresent(it -> {
            var bookingAccepted = it.accept();
            bookingRepository.save(it);

            domainEventPublisher.publish(bookingAccepted);

        });
    }


}
