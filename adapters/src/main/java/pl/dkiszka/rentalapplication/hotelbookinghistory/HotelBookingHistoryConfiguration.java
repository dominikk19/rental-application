package pl.dkiszka.rentalapplication.hotelbookinghistory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
@Configuration
class HotelBookingHistoryConfiguration {

    @Bean
    HotelBookingHistoryFacade hotelBookingHistoryFacade(SpringJpaHotelBookingHistoryRepository springRepository) {
        return new HotelBookingHistoryFacade(new JpaHotelBookingHistoryRepository(springRepository));
    }
}
