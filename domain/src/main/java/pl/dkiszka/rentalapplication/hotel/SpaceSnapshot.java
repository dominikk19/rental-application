package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
class SpaceSnapshot {
    private String id;
    private String name;
    private SquareMaterSnapshot squareMater;
}
