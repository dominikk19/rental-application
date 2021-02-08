package pl.dkiszka.rentalapplication.hotel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.02.2021
 */
@Entity
@Table(name = "hotelRoomBooking")
@NoArgsConstructor
@AllArgsConstructor
class SqlSimpleBooking {

    @Id
    private String id;

    SimpleBooking toSimpleBooking() {
        return new SimpleBooking(id);
    }
}
