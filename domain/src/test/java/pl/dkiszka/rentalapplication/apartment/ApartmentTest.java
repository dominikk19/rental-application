package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 20.01.2021
 */
class ApartmentTest {

    @Test
    void when_book_apartment_then_apartment_booked_event_should_be_returned() {
        var apartmentUuid = UUID.randomUUID().toString();
        var tenantId = UUID.randomUUID().toString();
        var ownerId = "6789";
        var startDate = LocalDate.now().plusDays(6);
        var endDate = LocalDate.now().plusDays(10);

        var apartment = createApartment(apartmentUuid, ownerId);

        var apartmentBookedEvent = apartment.bookedEvent(tenantId, new Period(startDate, endDate));

        ApartmentBookedEventAssertion.assertThat(apartmentBookedEvent)
                .hasOwnerIdEqualsTo(ownerId)
                .hasTenantIdEqualsTo(tenantId)
                .hasPeriodContainsStartDay(startDate)
                .hasPeriodContainsEndDay(endDate);
    }

    private Apartment createApartment(String apartmentUuid, String ownerId) {
        var addressSnapshot = AddressSnapshot.
                builder()
                .country("Poland")
                .city("Warsaw")
                .street("Polna")
                .postalCode("00-001")
                .houseNumber("1")
                .apartmentNumber("1")
                .build();
        return Apartment.restore(new ApartmentSnapshot(apartmentUuid, ownerId, addressSnapshot,
                Lists.newArrayList(new RoomSnapshot("", "salon", 35.00)),
                "small apartment",
                Lists.newArrayList()));
    }


}
