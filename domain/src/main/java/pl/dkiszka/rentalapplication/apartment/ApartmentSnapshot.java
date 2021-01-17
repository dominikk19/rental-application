package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class ApartmentSnapshot {
    private String id;
    private String ownerId;
    private AddressSnapshot address;
    private final Set<RoomSnapshot> rooms = Sets.newHashSet();
    private String description;

    ApartmentSnapshot(String id, String ownerId, AddressSnapshot address, final List<RoomSnapshot> rooms, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.description = description;
        this.rooms.addAll(rooms);
        this.address = address;
    }

}
