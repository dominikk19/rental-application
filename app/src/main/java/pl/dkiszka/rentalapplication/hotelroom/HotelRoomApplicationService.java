package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelRoomApplicationService {

    private final HotelRoomRepository hotelRoomRepository;

    public void add(String hotelId, int number, Map<String, Double> spacesDefinition, String descriptoin) {
        var hotelRoom = new HotelRoomFactory().create(hotelId, number, spacesDefinition, descriptoin);
        hotelRoomRepository.save(hotelRoom);
    }
}
