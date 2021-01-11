package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingDaySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingSnapshot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */

@Entity
@Table(name = "hotelRoomBooking")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlHotelRoomBooking {




    static SqlHotelRoomBooking from(HotelRoomBookingSnapshot snapshot) {
        var days = snapshot.getDays()
                .stream()
                .map(it -> new SqlHotelRoomBookingDay(it.getId(), it.getDay()))
                .collect(toList());
        return new SqlHotelRoomBooking(
                snapshot.getId(),
                snapshot.getBookingDateTime(),
                snapshot.getTenantId(),
                days);
    }

    @Id
    @GeneratedValue
    private String id;
    private LocalDateTime bookingDateTime;
    private String tenantId;

    @OneToMany
    private final Set<SqlHotelRoomBookingDay> days = Sets.newHashSet();

    private SqlHotelRoomBooking(String id, LocalDateTime bookingDateTime, String tenantId, List<SqlHotelRoomBookingDay> days) {
        this.id = id;
        this.bookingDateTime = bookingDateTime;
        this.tenantId = tenantId;
        this.days.addAll(days);
    }
}
