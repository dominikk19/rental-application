package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Apartment {
    private final String id;
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms = Lists.newArrayList();
    private final String description;

    ApartmentSnapshot getSnapshot() {
        var apartmentSnap = ApartmentSnapshot.builder()
                .id(id)
                .ownerId(ownerId)
                .address(address.getSnapshot())
                .description(description)
                .build();
        var roomsSnap = rooms.stream()
                .map(Room::getSnapshot)
                .collect(toList());
        apartmentSnap.getRooms().addAll(roomsSnap);
        return apartmentSnap;
    }

    ApartmentBookedEvent book(String tenantId, Period period) {
        var periodSnapshot = period.getSnapshot();
        return ApartmentBookedEvent.create(id, tenantId, ownerId, periodSnapshot.getStart(), periodSnapshot.getEnd());
    }
}
