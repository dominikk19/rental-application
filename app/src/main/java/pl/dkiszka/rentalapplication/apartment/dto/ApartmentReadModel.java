package pl.dkiszka.rentalapplication.apartment.dto;

import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
public interface ApartmentReadModel {


    String getId();

    String getOwnerId();

    AddressReadModel getAddress();

    List<RoomReadModel> getRooms();

    String getDescription();

    List<SimpleBooking> getBookings();
}
