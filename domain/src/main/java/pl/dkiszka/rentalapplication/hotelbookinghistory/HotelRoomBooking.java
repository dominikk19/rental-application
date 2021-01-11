package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingSnapshot;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
class HotelRoomBooking {

    static HotelRoomBooking restore(HotelRoomBookingSnapshot snapshot) {
        var days = snapshot.getDays().stream()
                .map(HotelRoomBookingDay::restore)
                .collect(Collectors.toList());
        return new HotelRoomBooking(snapshot.getId(),
                snapshot.getBookingDateTime(),
                snapshot.getTenantId(),
                days
        );
    }

    private final String id;
    private final LocalDateTime bookingDateTime;
    private final String tenantId;
    private final List<HotelRoomBookingDay> days = Lists.newArrayList();

    private HotelRoomBooking(String id, LocalDateTime bookingDateTime, String tenantId, List<HotelRoomBookingDay> days) {
        this.id = id;
        this.bookingDateTime = bookingDateTime;
        this.tenantId = tenantId;
        this.days.addAll(days);
    }


    HotelRoomBookingSnapshot getSnapshot() {
        return new HotelRoomBookingSnapshot(id, bookingDateTime, tenantId, days.stream()
                .map(HotelRoomBookingDay::getSnapshot).collect(Collectors.toList()));
    }
}
