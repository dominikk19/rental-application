package pl.dkiszka.rentalapplication.domain.apartment;

import pl.dkiszka.rentalapplication.app.apartment.dto.ApartmentDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
public class ApartmentFactory {

    public Apartment fromTo(String ownerId, ApartmentDto apartment) {
        var address = Address.fromDto(apartment.getAddress());
        var rooms= apartment.getRooms()
                .stream()
                .map(Room::fromDto)
                .collect(toList());
        return new Apartment(ownerId, address, rooms);
    }

}
