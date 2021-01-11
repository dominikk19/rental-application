package pl.dkiszka.rentalapplication.apartment;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 09.01.2021
 */
public interface ApartmentQueryRepository {

    Optional<ApartmentSnapshot> findById(String id);
}
