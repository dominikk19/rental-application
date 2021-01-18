package pl.dkiszka.rentalapplication.query.apartment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentReadModel;
import pl.dkiszka.rentalapplication.apartmentbookinghistory.dto.ApartmentBookingHistoryReadModel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
@RequiredArgsConstructor
@Getter
public class ApartmentDetails {
    private final ApartmentReadModel apartmentReadModel;
    @Setter
    private ApartmentBookingHistoryReadModel apartmentBookingHistoryReadModel;
}
