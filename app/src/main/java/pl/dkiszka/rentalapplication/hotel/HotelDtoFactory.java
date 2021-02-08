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
        var hotelSnapshot = hotel.toSnapshot();
        var address = fromAddress(hotelSnapshot.getAddress());
        return new HotelDto(hotelSnapshot.getId(), hotelSnapshot.getName(), address);
    }

    private static AddressDto fromAddress(AddressSnapshot address) {
        return AddressDto.builder()
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .buildingNumber(address.getBuildingNumber())
                .build();
    }
}
