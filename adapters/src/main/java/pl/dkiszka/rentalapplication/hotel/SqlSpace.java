package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Getter
class SqlSpace {

    static SqlSpace fromSpace(SpaceSnapshot space) {
        return new SqlSpace(space.getId(), space.getName(), JpaSquareMater.fromSquareMater(space.getSquareMater()));

    }

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @Embedded
    private JpaSquareMater squareMater;

    SpaceSnapshot toSpace() {
        return new SpaceSnapshot(id, name, new SquareMaterSnapshot(squareMater.getSize()));
    }
}
