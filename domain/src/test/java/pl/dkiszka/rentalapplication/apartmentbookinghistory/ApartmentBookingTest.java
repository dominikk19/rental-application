package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class ApartmentBookingTest {

    @Test
    void should_create_apartment_booking_with_all_required_information() {
        var bookingTime = LocalDateTime.of(2020, 1, 2, 3, 4);
        var ownerId = "123";
        var tenantId = "555";
        var start = LocalDate.of(2020, 2, 1);
        var end = LocalDate.of(2020, 2, 8);


        var actualApartmentBooking = ApartmentBooking.start(bookingTime, ownerId, tenantId, start, end);


        ApartmentBookingAssertion.assertThat(actualApartmentBooking)
                .hasBookingDateTime(bookingTime)
                .hasOwnerIdEqualTo(ownerId)
                .hasTenatIdEqualTo(tenantId)
                .hasBookingPeriodThatHas(start, end);

    }

}
