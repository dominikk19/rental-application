package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor
@Repository
class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;


    @Override
    public Apartment save(Apartment apartment) {
        return Apartment.restore(springJpaApartmentRepository.save(apartment.getSnapshot()));
    }

    @Override
    public Optional<Apartment> findById(String id) {
        return Optional.of(springJpaApartmentRepository.findById(id)
                .map(Apartment::restore)
                .orElseThrow(()->new ApartmentNotFoundException(String.format("Apartment id %s not found", id))));
    }
}
