package pl.dkiszka.rentalapplication.apartment.dto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
public interface AddressReadModel {

    String getCountry();

    String getCity();

    String getStreet();

    String getPostalCode();

    String getHouseNumber();

    String getApartmentNumber();
}
