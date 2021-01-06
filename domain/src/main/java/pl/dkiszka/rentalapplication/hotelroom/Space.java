package pl.dkiszka.rentalapplication.hotelroom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor
@Getter
class Space {
    private final String id;
    private final String name;
    private final SquareMater squareMater;


}
