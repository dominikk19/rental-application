package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelApplicationService {

    private final HotelRepository hotelRepository;

    public void add(final String name, final String counrty, final String city, final String street, final String postalCode, final String buildingNumber){
        var hotel =  new HotelFactory().create(name,counrty,city, street, postalCode, buildingNumber);
        hotelRepository.save(hotel);
    }
}
