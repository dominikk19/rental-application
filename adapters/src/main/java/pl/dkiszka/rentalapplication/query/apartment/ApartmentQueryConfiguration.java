package pl.dkiszka.rentalapplication.query.apartment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.apartment.ApartmentQueryRepository;
import pl.dkiszka.rentalapplication.apartmentbookinghistory.ApartmentBookingHistoryQueryRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
@Configuration
class ApartmentQueryConfiguration {

    @Bean
    QueryApartmentRepository queryApartmentRepository(ApartmentQueryRepository apartmentQueryRepository,
                                                      ApartmentBookingHistoryQueryRepository apartmentBookingHistoryQueryRepository) {
        return new QueryApartmentRepository(apartmentQueryRepository, apartmentBookingHistoryQueryRepository);
    }
}
