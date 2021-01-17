package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class SquareMater {

    static SquareMater restore(SquareMaterSnapshot squareMaterSnapshot) {
        return new SquareMater(squareMaterSnapshot.getSize());

    }

    private final Double size;

    SquareMaterSnapshot getSnapShot() {
        return new SquareMaterSnapshot(size);
    }

}
