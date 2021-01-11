package pl.dkiszka.rentalapplication.hotelbookinghistory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelBookingHistorySnapshot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@Entity
@Table(name = "hotelRoomBookingDay")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class SqlHotelRoomBookingDay {

    @Id
    @GeneratedValue
    private String id;

    private LocalDate day;

}
