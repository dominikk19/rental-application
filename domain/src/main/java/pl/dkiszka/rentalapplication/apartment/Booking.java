package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class Booking {

    static Booking restore(BookingSnapshot snapshot) {
        return new Booking(snapshot.getId(),
                snapshot.getUuid(),
                snapshot.getApartmentId(),
                snapshot.getTenantId(),
                Period.restore(snapshot.getPeriod()));
    }

    static Booking create(String apartmentId, String tenantId, Period period) {
        return new Booking(Strings.EMPTY,
                UUID.randomUUID().toString(),
                apartmentId,
                tenantId,
                period);
    }

    private final String id;
    private final String uuid;
    private final String apartmentId;
    private final String tenantId;
    private final Period period;


    BookingSnapshot getSnapshot() {
        return new BookingSnapshot(id, uuid, apartmentId, tenantId, period.getSnapshot());
    }


}
