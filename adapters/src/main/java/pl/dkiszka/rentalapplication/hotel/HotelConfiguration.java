package pl.dkiszka.rentalapplication.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.booking.BookingFacade;
import pl.dkiszka.rentalapplication.eventchanel.SpringDomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Configuration
class HotelConfiguration {

    @Bean
    HotelApplicationService hotelApplicationService(JpaHotelRepository jpaHotelRepository,
                                                    BookingFacade bookingFacade,
                                                    SpringDomainEventPublisher publisher) {
        return new HotelApplicationService(jpaHotelRepository, bookingFacade, publisher);
    }
}
