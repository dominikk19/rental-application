package pl.dkiszka.rentalapplication.apartment;

import pl.dkiszka.rentalapplication.apartment.dto.ApartmentReadModel;

import java.util.List;
import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 09.01.2021
 */
public interface ApartmentQueryRepository {

    List<ApartmentReadModel> findDtoAllBy();

    Optional<ApartmentReadModel> findDtoById(String id);
}
