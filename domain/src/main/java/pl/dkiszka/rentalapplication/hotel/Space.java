package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class Space {

    static Space restore(SpaceSnapshot spaceSnapshot) {
        return new Space(spaceSnapshot.getId(),
                spaceSnapshot.getName(),
                SquareMater.restore(spaceSnapshot.getSquareMater()));
    }

    private final String id;
    private final String name;
    private final SquareMater squareMater;

    SpaceSnapshot getSnapsot() {
        return new SpaceSnapshot(id, name, squareMater.getSnapShot());
    }


}
