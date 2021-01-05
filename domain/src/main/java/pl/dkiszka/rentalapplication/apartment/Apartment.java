package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@Getter
class Apartment {
    private final String id;
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms = Lists.newArrayList();
    private String description;

    public Apartment(String id, String ownerId, Address address, List<Room> rooms) {
        this.ownerId = ownerId;
        this.id = id;
        this.address = address;
        this.rooms.addAll(rooms);
    }

    void addDescription(String description) {
        this.description = description;
    }

}
