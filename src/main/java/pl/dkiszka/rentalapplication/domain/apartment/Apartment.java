package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.ApartmentDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
@Getter
public class Apartment {
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms;
    private String description;

    public static Apartment fromTo(String ownerId, ApartmentDto apartment) {
        var address = Address.fromDto(apartment.getAddress());
        var rooms= apartment.getRooms()
                .stream()
                .map(Room::fromDto)
                .collect(toList());
        return new Apartment(ownerId, address, rooms);
    }

    public void addDescription(String description){
        this.description = description;
    }

}
