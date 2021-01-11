package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
interface ApartmentBookingHistoryRepository {

    Optional<ApartmentBookingHistory> findByApartmentUuid(String apartmentUuid);

    ApartmentBookingHistory save(ApartmentBookingHistory apartmentBookingHistory);

}
