package pl.dkiszka.rentalapplication.adapters.persistence.jpa;

import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
interface SpringJpaApartmentRepository extends Repository<Apartment, String> {
    void save(Apartment apartment);
}
