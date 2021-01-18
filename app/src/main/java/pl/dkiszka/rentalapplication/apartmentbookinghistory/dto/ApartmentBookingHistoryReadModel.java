package pl.dkiszka.rentalapplication.apartmentbookinghistory.dto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface ApartmentBookingHistoryReadModel {

    String getId();

    String getApartmentUuid();

    List<ApartmentBookingReadModel> getBookings();
}
