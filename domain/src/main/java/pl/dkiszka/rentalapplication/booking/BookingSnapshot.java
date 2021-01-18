package pl.dkiszka.rentalapplication.booking;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class BookingSnapshot {
    private String id;
    private String uuid;
    private String rentalPlaceId;
    private RentalType rentalType;
    private String tenantId;
    private final List<BookingDaySnapshot> days = Lists.newArrayList();
    private BookingStatus bookingStatus;

    BookingSnapshot(String id, String uuid, String rentalPlaceId, RentalType rentalType, String tenantId,
                    List<BookingDaySnapshot> days, BookingStatus bookingStatus) {
        this.id = id;
        this.uuid = uuid;
        this.rentalPlaceId = rentalPlaceId;
        this.rentalType = rentalType;
        this.tenantId = tenantId;
        this.days.addAll(days);
        this.bookingStatus = bookingStatus;
    }
}
