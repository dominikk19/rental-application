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
        var apartmentSnapshot = apartment.getSnapshot();
        var romms = apartmentSnapshot.getRooms().stream()
                .map(ApartmentDtoFactory::fromRoom)
                .collect(toList());
        var address = fromAddress(apartmentSnapshot.getAddress());

        return new ApartmentDto(apartmentSnapshot.getUuid(), apartmentSnapshot.getOwnerId(), address, romms, apartmentSnapshot.getDescription());

    }

    private static RoomDto fromRoom(RoomSnapshot room) {
        return new RoomDto(room.getId(), room.getName(), room.getSize());
    }

    private static AddressDto fromAddress(AddressSnapshot address) {
        return AddressDto.builder()
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .houseNumber(address.getHouseNumber())
                .apartmentNumber(address.getApartmentNumber())
                .build();
    }
}
