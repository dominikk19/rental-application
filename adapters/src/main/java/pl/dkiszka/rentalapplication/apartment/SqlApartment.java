package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 03.01.2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
class SqlApartment {

    static SqlApartment fromApartment(final Apartment apartment) {
        var rooms = apartment.getRooms()
                .stream()
                .map(SqlRoom::fromRoom)
                .collect(toList());

        return new SqlApartment(apartment.getId(),
                apartment.getOwnerId(),
                SqlAddress.fromAddress(apartment.getAddress()),
                rooms,
                apartment.getDescription());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String ownerId;

    @Embedded
    private SqlAddress address;

    @OneToMany
    private final Set<SqlRoom> rooms = Sets.newHashSet();

    private String description;


    public SqlApartment(String id, String ownerId, SqlAddress address, List<SqlRoom> rooms, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.address = address;
        this.rooms.addAll(rooms);
        this.description = description;
    }

    Apartment toApartment() {
        var apartmentRooms = rooms.stream()
                .map(SqlRoom::toRoom)
                .collect(toList());

        return new Apartment(id, ownerId, address.toAddress(), apartmentRooms);
    }
}
