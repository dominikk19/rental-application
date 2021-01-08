package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */

class Apartment {

    static Apartment restore(ApartmentSnapshot apartmentSnapshot) {
        return new Apartment(apartmentSnapshot.getId(),
                apartmentSnapshot.getOwnerId(),
                Address.restore(apartmentSnapshot.getAddress()),
                apartmentSnapshot.getRooms().stream().map(Room::restore).collect(toList()),
                apartmentSnapshot.getDescription());
    }

    private final String id;
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms = Lists.newArrayList();
    private final String description;

    public Apartment(String id, String ownerId, Address address, List<Room> rooms, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.address = address;
        this.rooms.addAll(rooms);
        this.description = description;
    }

    ApartmentSnapshot getSnapshot() {
        var roomsSnap = rooms.stream()
                .map(Room::getSnapshot)
                .collect(toList());
        return new ApartmentSnapshot(id, ownerId, address.getSnapshot(), roomsSnap, description);

    }

    ApartmentBookedEvent book(String tenantId, Period period) {
        var periodSnapshot = period.getSnapshot();
        return ApartmentBookedEvent.create(id, tenantId, ownerId, periodSnapshot.getStart(), periodSnapshot.getEnd());
    }
}
