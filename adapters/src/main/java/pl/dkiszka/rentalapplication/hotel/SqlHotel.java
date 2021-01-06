package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class SqlHotel {

    static SqlHotel fromHotel(Hotel hotel) {
        var sqlAddress = SqlAddress.fromAddress(hotel.getAddress());
        return new SqlHotel(hotel.getId(), hotel.getName(), sqlAddress);
    }

    @Id
    @GeneratedValue
    private String id;

    private String name;

    @Embedded
    private SqlAddress address;
}
