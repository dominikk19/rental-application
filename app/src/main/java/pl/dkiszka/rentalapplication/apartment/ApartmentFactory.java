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

    Apartment fromDtoTo(ApartmentDto apartmentDto) {
        var address = extractAddressFromDto(apartmentDto.getAddress());
        var rooms = extractRoomsFromDto(apartmentDto.getRooms());
        return Apartment.restore(new ApartmentSnapshot(apartmentDto.getId(), apartmentDto.getOwnerId(), address, rooms, apartmentDto.getDescription()));
    }

    private AddressSnapshot extractAddressFromDto(AddressDto addressDto) {
        return AddressSnapshot.builder()
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .postalCode(addressDto.getPostalCode())
                .houseNumber(addressDto.getHouseNumber())
                .apartmentNumber(addressDto.getApartmentNumber())
                .build();
    }

    private List<RoomSnapshot> extractRoomsFromDto(List<RoomDto> rooms) {
        return rooms
                .stream()
                .map(this::convertRoomFromDto)
                .collect(toList());
    }

    private RoomSnapshot convertRoomFromDto(RoomDto room) {
        return new RoomSnapshot(room.getId(), room.getName(), room.getSize());
    }

}
