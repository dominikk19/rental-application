package pl.dkiszka.rentalapplication.apartment;


import org.springframework.data.repository.Repository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
interface SpringJpaApartmentRepository extends Repository<SqlApartment, String> {
    SqlApartment save(SqlApartment apartment);
}
