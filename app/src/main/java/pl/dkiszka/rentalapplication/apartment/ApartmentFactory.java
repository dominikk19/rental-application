package pl.dkiszka.rentalapplication.apartment;


import pl.dkiszka.rentalapplication.apartment.dto.AddressDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.apartment.dto.RoomDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class ApartmentFactory {

    Apartment fromDtoTo(ApartmentDto apartment) {
        var address = extractAddressFromDto(apartment.getAddress());
        var rooms = extractRoomsFromDto(apartment.getRooms());
        return new Apartment(apartment.getId(), apartment.getOwnerId(), address, rooms);
    }

    private Address extractAddressFromDto(AddressDto addressDto) {
        return Address.builder()
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .postalCode(addressDto.getPostalCode())
                .houseNumber(addressDto.getHouseNumber())
                .apartmentNumber(addressDto.getApartmentNumber())
                .build();
    }

    private List<Room> extractRoomsFromDto(List<RoomDto> rooms) {
        return rooms
                .stream()
                .map(this::convertRoomFromDto)
                .collect(toList());
    }

    private Room convertRoomFromDto(RoomDto room) {
        return new Room(room.getId(), room.getName(), new SquareMater(room.getSize()));
    }

}
