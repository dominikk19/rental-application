package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class ApartmentBookingSnapshot {

    private String id;
    private String uuid;
    private LocalDateTime bookingDataTime;
    private BookingStep bookingStep;
    private String ownerId;
    private String tenantId;
    private LocalDate periodStart;
    private LocalDate periodEnd;
}
