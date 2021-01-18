package pl.dkiszka.rentalapplication.hotel;

import pl.dkiszka.rentalapplication.hotel.dto.HotelReadModel;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */
public interface HotelQueryRepository {
    List<HotelReadModel> findDtoAllBy();
}
