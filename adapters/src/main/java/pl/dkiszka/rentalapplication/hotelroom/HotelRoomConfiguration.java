package pl.dkiszka.rentalapplication.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.common.events.SpringDomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@RequiredArgsConstructor
@Configuration
class HotelRoomConfiguration {

    @Bean
    HotelRoomApplicationService hotelRoomApplicationService(SpringJpaHotelRoomRepository springJpaHotelRoomRepository,
                                                            SpringDomainEventPublisher publisher) {
        return new HotelRoomApplicationService(new JpaHotelRoomRepository(springJpaHotelRoomRepository), publisher);
    }
}
