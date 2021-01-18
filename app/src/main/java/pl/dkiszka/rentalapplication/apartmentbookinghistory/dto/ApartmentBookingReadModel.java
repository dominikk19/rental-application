package pl.dkiszka.rentalapplication.apartmentbookinghistory.dto;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface ApartmentBookingReadModel {

    String getId();

    String getUuid();

    String getBookingStep();

    String getOwnerId();

    String getTenantId();

    LocalDate getPeriodStart();

    LocalDate getPeriodEnd();
}
