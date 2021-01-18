package pl.dkiszka.rentalapplication.apartment;

import org.springframework.data.repository.Repository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
interface SqlApartmentQueryRepository extends ApartmentQueryRepository, Repository<ApartmentSnapshot, String> {

}
