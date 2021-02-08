package pl.dkiszka.rentalapplication.hotel;

import org.assertj.core.util.Lists;
import pl.dkiszka.rentalapplication.hotel.dto.AddressDto;
import pl.dkiszka.rentalapplication.hotel.dto.HotelDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class HotelFactory {

    Hotel create(HotelDto hotelDto) {
        var address = extractAddressFromDto(hotelDto.getAddress());
        return new Hotel(hotelDto.getId(), hotelDto.getName(), address, Lists.emptyList());
    }

    private Address extractAddressFromDto(AddressDto addressDto) {
        return new Address(addressDto.getCountry(),
                addressDto.getCity(),
                addressDto.getStreet(),
                addressDto.getPostalCode(),
                addressDto.getBuildingNumber());
    }
}
