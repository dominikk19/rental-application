package pl.dkiszka.rentalapplication.apartment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.DomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.01.2021
 */
@Configuration
class ApartmentConfiguration {

    @Bean
    ApartmentApplicationService apartmentApplicationService(SpringJpaApartmentRepository springJpaApartmentRepository,
                                                            DomainEventPublisher domainEventPublisher){
        return new ApartmentApplicationService(new JpaApartmentRepository(springJpaApartmentRepository), domainEventPublisher);
    }
}
