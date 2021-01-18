package pl.dkiszka.rentalapplication.apartment;

import pl.dkiszka.rentalapplication.apartment.dto.ApartmentReadModel;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 09.01.2021
 */
interface ApartmentQueryRepository {

    List<ApartmentReadModel> findDtoAllBy();
}
