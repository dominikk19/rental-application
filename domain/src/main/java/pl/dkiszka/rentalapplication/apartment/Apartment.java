package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */

class Apartment {

    static Apartment restore(ApartmentSnapshot apartmentSnapshot) {
        return new Apartment(apartmentSnapshot.getUuid(),
                apartmentSnapshot.getOwnerId(),
                Address.restore(apartmentSnapshot.getAddress()),
                apartmentSnapshot.getRooms().stream().map(Room::restore).collect(toList()),
                apartmentSnapshot.getDescription(),
                Lists.newArrayList(apartmentSnapshot.getBookings())
        );
    }

    private final String uuid;
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms = Lists.newArrayList();
    private final String description;
    private final List<SimpleBooking> bookings = Lists.newArrayList();

    public Apartment(String uuid, String ownerId, Address address, List<Room> rooms, String description, List<SimpleBooking> bookings) {
        this.uuid = uuid;
        this.ownerId = ownerId;
        this.address = address;
        this.rooms.addAll(rooms);
        this.description = description;
        this.bookings.addAll(bookings);
    }

    ApartmentSnapshot getSnapshot() {
        var roomsSnap = rooms.stream()
                .map(Room::getSnapshot)
                .collect(toList());
        return new ApartmentSnapshot(uuid, ownerId, address.getSnapshot(), roomsSnap, description, bookings);

    }

    ApartmentBookedEvent bookedEvent(String tenantId, Period period) {
        var periodSnapshot = period.getSnapshot();
        return ApartmentBookedEvent.create(uuid, tenantId, ownerId, periodSnapshot.getStart(), periodSnapshot.getEnd());
    }

    Apartment addBooking(SimpleBooking booking) {
        bookings.add(booking);
        return this;
    }
}
