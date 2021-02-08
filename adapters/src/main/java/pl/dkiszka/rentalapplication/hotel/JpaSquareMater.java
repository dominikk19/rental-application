package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class JpaSquareMater {

    static JpaSquareMater fromSquareMater(SquareMaterSnapshot squareMater) {
        return new JpaSquareMater(squareMater.getSize());
    }

    private Double size;
}
