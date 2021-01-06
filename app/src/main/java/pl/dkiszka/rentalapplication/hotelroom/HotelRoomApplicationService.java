package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelRoomApplicationService {

    private final HotelRoomRepository hotelRoomRepository;

    public HotelRoomDto add(HotelRoomDto hotelRoomDto) {
        var hotelRoom = new HotelRoomFactory().create(hotelRoomDto);
        return HotelRoomDtoFactory.fromHotelRoom(hotelRoomRepository.save(hotelRoom));
    }
}
