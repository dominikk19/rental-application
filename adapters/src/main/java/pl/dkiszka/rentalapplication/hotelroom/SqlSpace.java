package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class SqlSpace {

    static SqlSpace fromSpace(Space space) {
        return new SqlSpace(space.getId(), space.getName(), JpaSquareMater.fromSquareMater(space.getSquareMater()));

    }

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @Embedded
    private JpaSquareMater squareMater;
}
