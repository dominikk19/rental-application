package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@Getter
class ApartmentBookingHistorySnapshot {
    private String id;
    private String apartmentUuid;
    private final List<ApartmentBookingSnapshot> bookings = Lists.newArrayList();

    ApartmentBookingHistorySnapshot(String id, String apartmentUuid, List<ApartmentBookingSnapshot> bookings) {
        this.id = id;
        this.apartmentUuid = apartmentUuid;
        this.bookings.addAll(bookings);
    }
}
