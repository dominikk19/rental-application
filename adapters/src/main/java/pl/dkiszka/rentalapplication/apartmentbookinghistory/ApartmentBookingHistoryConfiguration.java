package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */

@Configuration
class ApartmentBookingHistoryConfiguration {

    @Bean
    ApartmentBookingHistoryFacade apartmentBookingHistoryFacade(JpaApartmentBookingHistoryRepository jpaApartmentBookingHistoryRepository) {
        return new ApartmentBookingHistoryFacade(jpaApartmentBookingHistoryRepository);
    }
}
