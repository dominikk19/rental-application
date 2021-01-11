package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingHistorySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingSnapshot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@Entity
@Table(name = "hotelRoomBookingHistory")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlHotelRoomBookingHistory {

    static SqlHotelRoomBookingHistory from(HotelRoomBookingHistorySnapshot snapshot){
        var bookings = snapshot.getBookingsSnapshot()
                .stream()
                .map(SqlHotelRoomBooking::from)
                .collect(Collectors.toList());

        return new SqlHotelRoomBookingHistory(snapshot.getHotelRoomId(), bookings);
    }

    @Id
    @GeneratedValue
    private String hotelId;

    @OneToMany
    private final Set<SqlHotelRoomBooking> bookings = Sets.newHashSet();

    SqlHotelRoomBookingHistory(String hotelId, List<SqlHotelRoomBooking> hotelRoomBooking) {
        this.hotelId = hotelId;
        hotelRoomBooking.forEach(bookings::add);
    }
}
