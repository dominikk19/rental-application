package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
public class Apartment {
    @Id
    @GeneratedValue
    private String id;
    private final String ownerId;
    @Embedded
    private final Address address;

    @OneToMany
    private final List<Room> rooms;
    private String description;



    void addDescription(String description){
        this.description = description;
    }

}
