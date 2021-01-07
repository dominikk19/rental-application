package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor
class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;


    @Override
    public Apartment save(Apartment apartment) {
        var sqlApartment = SqlApartment.fromApartment(apartment);
        return springJpaApartmentRepository.save(sqlApartment).toApartment();
    }

    @Override
    public Optional<Apartment> findById(String id) {
        return springJpaApartmentRepository.findById(id)
                .map(SqlApartment::toApartment);
    }
}
