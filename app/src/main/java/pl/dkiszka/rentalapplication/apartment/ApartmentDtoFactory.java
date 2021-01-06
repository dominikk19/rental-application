package pl.dkiszka.rentalapplication.apartment;

import pl.dkiszka.rentalapplication.apartment.dto.AddressDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.apartment.dto.RoomDto;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
class ApartmentDtoFactory {


    static ApartmentDto fromApartment(Apartment apartment) {
        var romms = apartment.getRooms().stream()
                .map(ApartmentDtoFactory::fromRoom)
                .collect(toList());
        var address = fromAddress(apartment.getAddress());

        return new ApartmentDto(apartment.getId(), apartment.getOwnerId(), address, romms, apartment.getDescription());

    }

    static RoomDto fromRoom(Room room) {
        return new RoomDto(room.getId(), room.getName(), room.getSize().getSize());
    }

    static AddressDto fromAddress(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .houseNumber(address.getHouseNumber())
                .apartmentNumber(address.getApartmentNumber())
                .build();
    }
}
