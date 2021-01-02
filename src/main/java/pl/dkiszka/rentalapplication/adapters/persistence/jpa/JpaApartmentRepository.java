package pl.dkiszka.rentalapplication.adapters.persistence.jpa;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor
class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;

    @Override
    public void save(Apartment apartment) {
        springJpaApartmentRepository.save(apartment);
    }
}
