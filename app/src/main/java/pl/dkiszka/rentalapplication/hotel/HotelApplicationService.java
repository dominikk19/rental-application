package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.hotel.dto.HotelDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelApplicationService {

    private final HotelRepository hotelRepository;

    public HotelDto add(HotelDto hotelDto){
        var hotel =  new HotelFactory().create(hotelDto);
        return HotelDtoFactory.fromHotel(hotelRepository.save(hotel));
    }
}
