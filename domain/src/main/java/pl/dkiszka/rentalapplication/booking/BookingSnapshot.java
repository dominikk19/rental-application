package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class BookingSnapshot {
    private String id;
    private String uuid;
    private String rentalPlaceId;
    private RentalType rentalType;
    private String tenantId;
    private final List<BookingDaySnapshot> days;
    private BookingStatus bookingStatus;
}
