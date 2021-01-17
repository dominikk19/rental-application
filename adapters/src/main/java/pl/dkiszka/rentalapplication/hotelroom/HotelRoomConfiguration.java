package pl.dkiszka.rentalapplication.hotelroom;

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
class HotelRoomConfiguration {

    @Bean
    HotelRoomApplicationService hotelRoomApplicationService(JpaHotelRoomRepository jpaHotelRoomRepository,
                                                            BookingFacade bookingFacade,
                                                            SpringDomainEventPublisher publisher) {
        return new HotelRoomApplicationService(jpaHotelRoomRepository, bookingFacade, publisher);
    }
}
