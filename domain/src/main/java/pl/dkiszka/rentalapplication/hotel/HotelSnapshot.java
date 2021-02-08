package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.02.2021
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class HotelSnapshot {
    private final String id;
    private final String name;
    private final AddressSnapshot address;
    private final List<RoomSnapshot> rooms;
}