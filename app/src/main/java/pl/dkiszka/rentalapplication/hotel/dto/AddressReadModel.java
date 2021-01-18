package pl.dkiszka.rentalapplication.hotel.dto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface AddressReadModel {

    String getCountry();

    String getCity();

    String getStreet();

    String getPostalCode();

    String getBuildingNumber();
}
