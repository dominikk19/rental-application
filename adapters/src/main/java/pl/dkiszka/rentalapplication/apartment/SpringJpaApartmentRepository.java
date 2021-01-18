package pl.dkiszka.rentalapplication.apartment;


import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
interface SpringJpaApartmentRepository extends Repository<ApartmentSnapshot, String> {
    Optional<ApartmentSnapshot> findById(String id);

    ApartmentSnapshot save(ApartmentSnapshot apartment);
}


