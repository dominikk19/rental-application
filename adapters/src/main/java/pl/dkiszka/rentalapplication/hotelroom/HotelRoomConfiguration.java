package pl.dkiszka.rentalapplication.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.eventchanel.SpringDomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Configuration
class HotelRoomConfiguration {

    @Bean
    HotelRoomApplicationService hotelRoomApplicationService(JpaHotelRoomRepository jpaHotelRoomRepository,
                                                            SpringDomainEventPublisher publisher) {
        return new HotelRoomApplicationService(jpaHotelRoomRepository, publisher);
    }
}
