package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class HotelRoom {
    private final String hotelId;
    private final int number;
    private final List<Space> spaces;
    private final String description;

}
