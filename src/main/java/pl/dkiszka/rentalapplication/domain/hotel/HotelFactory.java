package pl.dkiszka.rentalapplication.domain.hotel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
public class HotelFactory {
    public Hotel create(final String name, final String counrty, final String city, final String street, final String postalCode, final String buildingNumber) {
        var address = new Address(counrty, city, street, postalCode, buildingNumber);
        return new Hotel(name, address);
    }
}
