package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 03.01.2021
 */

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class JpaSquareMater {

    static JpaSquareMater fromSquareMater(SquareMater squareMater) {
        return new JpaSquareMater(squareMater.getSize());
    }

    private Double size;
}
