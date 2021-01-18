package pl.dkiszka.rentalapplication.hotel;

import org.springframework.data.repository.Repository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
interface SqlHotelQueryRepository extends HotelQueryRepository, Repository<SqlHotel, String> {
}
