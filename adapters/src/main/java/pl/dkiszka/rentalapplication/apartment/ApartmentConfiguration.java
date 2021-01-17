package pl.dkiszka.rentalapplication.apartment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.booking.BookingFacade;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@Configuration
class ApartmentConfiguration {

    @Bean
    ApartmentApplicationService apartmentApplicationService(JpaApartmentRepository jpaApartmentRepository,
                                                            BookingFacade bookingFacade,
                                                            DomainEventPublisher publisher) {
        return new ApartmentApplicationService(jpaApartmentRepository, bookingFacade, publisher);
    }

}
