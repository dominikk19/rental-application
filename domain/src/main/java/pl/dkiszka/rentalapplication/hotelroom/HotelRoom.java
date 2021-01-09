package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.hotelroom.vo.HotelRoomBookedEvent;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class HotelRoom {
    private final String id;
    private final String hotelId;
    private final int number;
    private final List<Space> spaces;
    private final String description;

    HotelRoomBookedEvent book(String tenantId, List<LocalDate> days){
        return HotelRoomBookedEvent.create(hotelId,id,tenantId,days);
    }

}
