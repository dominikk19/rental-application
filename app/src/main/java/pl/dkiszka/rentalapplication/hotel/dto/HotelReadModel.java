package pl.dkiszka.rentalapplication.hotel.dto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface HotelReadModel {

    String getId();

    String getName();

    AddressReadModel getAddress();
}
