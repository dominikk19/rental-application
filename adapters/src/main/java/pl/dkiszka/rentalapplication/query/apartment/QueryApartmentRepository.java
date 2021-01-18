package pl.dkiszka.rentalapplication.query.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.ApartmentQueryRepository;
import pl.dkiszka.rentalapplication.apartmentbookinghistory.ApartmentBookingHistoryQueryRepository;
import pl.dkiszka.rentalapplication.query.apartment.dto.ApartmentDetails;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class QueryApartmentRepository {
    private final ApartmentQueryRepository apartmentQueryRepository;
    private final ApartmentBookingHistoryQueryRepository apartmentBookingHistoryQueryRepository;


    ApartmentDetails findById(String id) {
        var apartmentDetails = apartmentQueryRepository.findDtoById(id)
                .map(ApartmentDetails::new)
                .orElseThrow(() -> new DataNotFoundException(String.format("apartment by id %s not found", id)));
        apartmentBookingHistoryQueryRepository.findDtoByApartmentUuid(id)
                .ifPresent(apartmentDetails::setApartmentBookingHistoryReadModel);

        return apartmentDetails;
    }
}
