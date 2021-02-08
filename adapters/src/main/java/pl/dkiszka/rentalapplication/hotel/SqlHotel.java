package pl.dkiszka.rentalapplication.hotel;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "hotel")
class SqlHotel {

    static SqlHotel fromHotel(Hotel hotel) {
        var hoteSnapshot = hotel.toSnapshot();
        var sqlAddress = SqlAddress.fromAddress(hoteSnapshot.getAddress());
        return new SqlHotel(hoteSnapshot.getId(), hoteSnapshot.getName(), sqlAddress);
    }

    @Id
    @GeneratedValue
    private String id;

    private String name;

    @Embedded
    private SqlAddress address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private final List<SqlRoom> rooms = Lists.newArrayList();

    Hotel toHotel() {
        var hotelAddress = address.toAddress();
        var roomsSnapshot = rooms.stream()
                .map(SqlRoom::toHotelRoom)
                .collect(Collectors.toList());
        return Hotel.restore(new HotelSnapshot(id, name, hotelAddress, roomsSnapshot));
    }
}
