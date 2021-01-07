package pl.dkiszka.rentalapplication.apartment;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
interface ApartmentRepository {
    Apartment save(Apartment apartment);

    Optional<Apartment> findById(String id);
}
