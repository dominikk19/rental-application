package pl.dkiszka.rentalapplication.hotel;


import pl.dkiszka.rentalapplication.hotel.dto.AddressDto;
import pl.dkiszka.rentalapplication.hotel.dto.HotelDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
class HotelDtoFactory {

    static HotelDto fromHotel(Hotel hotel) {
        var address = fromAddress(hotel.getAddress());
        return new HotelDto(hotel.getId(), hotel.getName(), address);
    }

    private static AddressDto fromAddress(Address address){
        return AddressDto.builder()
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .buildingNumber(address.getBuildingNumber())
                .build();
    }
}
