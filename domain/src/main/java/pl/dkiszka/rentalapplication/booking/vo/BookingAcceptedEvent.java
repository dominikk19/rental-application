package pl.dkiszka.rentalapplication.booking.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookingAcceptedEvent {

    public static BookingAcceptedEvent create(String rentalType, String rentalPlaceId, String tenantId, List<LocalDate> bookingDays) {
        return new BookingAcceptedEvent(UUID.randomUUID().toString(), LocalDateTime.now(), rentalType, rentalPlaceId, tenantId, bookingDays);
    }

    private final String eventId;
    private final LocalDateTime eventCreationDateTime;
    private final String rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;

}
