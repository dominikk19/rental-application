package pl.dkiszka.rentalapplication.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Configuration
class HotelConfiguration {

    @Bean
    HotelApplicationService hotelApplicationService(SpringJpaHotelRepository springJpaHotelRepository){
        return new HotelApplicationService(new JpaHotelRepository(springJpaHotelRepository));
    }
}
