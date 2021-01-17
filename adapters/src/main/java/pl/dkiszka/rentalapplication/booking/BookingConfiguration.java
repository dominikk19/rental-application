package pl.dkiszka.rentalapplication.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@Configuration
class BookingConfiguration {

    @Bean
    BookingFacade bookingFacade(JpaBookingRepository jpaBookingRepository) {
        return new BookingFacade(jpaBookingRepository);
    }
}
