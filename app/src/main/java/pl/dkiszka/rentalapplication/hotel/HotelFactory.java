package pl.dkiszka.rentalapplication.hotel;

import org.apache.logging.log4j.util.Strings;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
class HotelFactory {

    public Hotel create(final String name, final String counrty, final String city, final String street, final String postalCode, final String buildingNumber) {
        var address = new Address(counrty, city, street, postalCode, buildingNumber);
        return new Hotel(Strings.EMPTY,name, address);
    }
}
