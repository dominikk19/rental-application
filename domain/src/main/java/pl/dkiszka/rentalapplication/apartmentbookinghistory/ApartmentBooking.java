package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBooking {

    static ApartmentBooking restore(ApartmentBookingSnapshot apartmentBookingSnapshot) {
        return new ApartmentBooking(
                apartmentBookingSnapshot.getId(),
                apartmentBookingSnapshot.getUuid(),
                apartmentBookingSnapshot.getBookingStep(),
                apartmentBookingSnapshot.getOwnerId(),
                apartmentBookingSnapshot.getTenantId(),
                apartmentBookingSnapshot.getPeriodStart(),
                apartmentBookingSnapshot.getPeriodEnd());
    }

    static ApartmentBooking start(String ownerId, String tenantId, LocalDate periodStart, LocalDate periodEnd) {
        return new ApartmentBooking(Strings.EMPTY, UUID.randomUUID().toString(), BookingStep.START, ownerId, tenantId, periodStart, periodEnd);
    }

    private final String id;
    private final String uuid;
    private final BookingStep bookingStep;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate periodStart;
    private final LocalDate periodEnd;

    ApartmentBookingSnapshot getSnapshot() {
        return new ApartmentBookingSnapshot(id, uuid, bookingStep, ownerId, tenantId, periodStart, periodEnd);
    }
}
