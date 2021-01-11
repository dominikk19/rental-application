package pl.dkiszka.rentalapplication.apartment.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApartmentBookedEvent {

    public static ApartmentBookedEvent create(String apartmentUuid, String tenantId, String ownerId, LocalDate start, LocalDate end) {
        return new ApartmentBookedEvent(UUID.randomUUID().toString(),
                LocalDateTime.now(),
                apartmentUuid,
                ownerId,
                tenantId,
                start,
                end);
    }

    private final String eventId;
    private final LocalDateTime eventCreationDataTime;
    private final String apartmentUuid;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate start;
    private final LocalDate end;


}
