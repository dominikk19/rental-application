package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 20.01.2021
 */
class ApartmentTest {

    @Test
    void should_return_event_apartment_booking_for_apartment() {
        var apartmentUuid = UUID.randomUUID().toString();
        var tenantId = UUID.randomUUID().toString();
        var period = new Period(LocalDate.now().plusDays(10), LocalDate.now().plusDays(6));

        var addressSnapshot = AddressSnapshot.
                builder()
                .country("Poland")
                .city("Warsaw")
                .street("Polna")
                .postalCode("00-001")
                .houseNumber("1")
                .apartmentNumber("1")
                .build();
        var apartment = Apartment.restore(new ApartmentSnapshot(apartmentUuid, "222", addressSnapshot,
                Lists.newArrayList(new RoomSnapshot("", "salon", 35.00)),
                "small apartment",
                Lists.newArrayList())

        );



        var event = apartment.bookedEvent(tenantId, period);


        assertThat(event.getTenantId()).isEqualTo(tenantId);
        assertThat(event.getApartmentUuid()).isEqualTo(apartmentUuid);

    }
}
