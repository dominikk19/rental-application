package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;

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
}
