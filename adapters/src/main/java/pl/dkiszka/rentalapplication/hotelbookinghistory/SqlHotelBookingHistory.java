package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelBookingHistorySnapshot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@Entity
@Table(name = "hotelBookingHistory")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class SqlHotelBookingHistory {

    static SqlHotelBookingHistory fromAddress(HotelBookingHistorySnapshot hotelBookingHistory) {
        var sqlHotelBookingHistory = hotelBookingHistory.getHotelRoomBookingHistories().stream()
                .map(SqlHotelRoomBookingHistory::from)
                .collect(toList());

        return new SqlHotelBookingHistory(
                hotelBookingHistory.getHotelId(),
                sqlHotelBookingHistory);
    }

    @Id
    @GeneratedValue
    private String hotelId;

    @OneToMany
    private final Set<SqlHotelRoomBookingHistory> hotelRoomBookingHistories = Sets.newHashSet();

    public SqlHotelBookingHistory(String hotelId, List<SqlHotelRoomBookingHistory> hotelRoomBookingHistories) {
        this.hotelId = hotelId;
        hotelRoomBookingHistories.forEach(hotelRoomBookingHistories::add);
    }
}
