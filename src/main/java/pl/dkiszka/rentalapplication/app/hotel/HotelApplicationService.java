package pl.dkiszka.rentalapplication.app.hotel;

import pl.dkiszka.rentalapplication.domain.hotel.HotelFactory;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
public class HotelApplicationService {
    public void add(final String name, final String counrty, final String city, final String street, final String postalCode, final String buildingNumber){
        new HotelFactory().create(name,counrty,city, street, postalCode, buildingNumber);
    }
}
