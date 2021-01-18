package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import pl.dkiszka.rentalapplication.apartmentbookinghistory.dto.ApartmentBookingHistoryReadModel;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface ApartmentBookingHistoryQueryRepository {
    Optional<ApartmentBookingHistoryReadModel> findDtoByApartmentUuid(String apartmentUuid);
}
