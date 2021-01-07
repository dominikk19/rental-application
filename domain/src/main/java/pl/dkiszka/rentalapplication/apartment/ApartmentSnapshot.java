package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
class ApartmentSnapshot {
    private String id;
    private String ownerId;
    private AddressSnapshot address;
    private final List<RoomSnapshot> rooms = Lists.newArrayList();
    private String description;
}
