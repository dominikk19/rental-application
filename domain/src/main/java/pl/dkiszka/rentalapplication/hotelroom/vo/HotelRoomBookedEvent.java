package pl.dkiszka.rentalapplication.hotelroom.vo;

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
 * @date 09.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class HotelRoomBookedEvent {

    public static HotelRoomBookedEvent create(String hotelId, String hotelRoomId, String tenantId, List<LocalDate> days) {

        return new HotelRoomBookedEvent(UUID.randomUUID().toString(),
                LocalDateTime.now(), hotelId, hotelRoomId, tenantId, days);
    }

    private final String eventId;
    private final LocalDateTime eventCreationDataTime;
    private final String hotelId;
    private final String hotelRoomId;
    private final String tenantId;
    private final List<LocalDate> days;
}
