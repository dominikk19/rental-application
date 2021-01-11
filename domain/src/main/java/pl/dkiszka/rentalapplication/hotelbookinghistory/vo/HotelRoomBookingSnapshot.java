package pl.dkiszka.rentalapplication.hotelbookinghistory.vo;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@Getter
public class HotelRoomBookingSnapshot {
    private String id;
    private LocalDateTime bookingDateTime;
    private String tenantId;
    private List<HotelRoomBookingDaySnapshot> days;

    public HotelRoomBookingSnapshot(String id, LocalDateTime bookingDateTime, String tenantId, List<HotelRoomBookingDaySnapshot> days) {
        this.id = id;
        this.bookingDateTime = bookingDateTime;
        this.tenantId = tenantId;
        this.days.addAll(days);
    }

    public HotelRoomBookingSnapshot(LocalDateTime bookingDateTime, String tenantId, List<LocalDate> days) {
        this.id = Strings.EMPTY;
        this.bookingDateTime = bookingDateTime;
        this.tenantId = tenantId;
        this.days.addAll(days.stream().map(it -> new HotelRoomBookingDaySnapshot(Strings.EMPTY, it)).collect(Collectors.toList()));
    }
}
