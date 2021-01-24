package pl.dkiszka.rentalapplication.booking;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class BookingTest {

    @Test
    void should_create_booking_for_apartment(){
        var rentalPlaceId = "567";
        var tenantId = "123567";
        var days = Lists.newArrayList(LocalDate.of(2020,3,4),
                LocalDate.of(2020,3,5),
                LocalDate.of(2020,3,6));

        var actualBooking= Booking.apartment(rentalPlaceId,tenantId,days);

        BookingAssertion.assertThat(actualBooking)
                .isOpen()
                .isApartment()
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .containsAllDays(LocalDate.of(2020,3,6),
                        LocalDate.of(2020,3,5),
                        LocalDate.of(2020,3,4));
    }


    @Test
    void should_create_booking_for_hotel_room(){
        var rentalPlaceId = "567";
        var tenantId = "123567";
        var days = Lists.newArrayList(LocalDate.of(2020,3,4),
                LocalDate.of(2020,3,5),
                LocalDate.of(2020,3,6));

        var actualBooking = Booking.hotelRoom(rentalPlaceId,tenantId,days);

        BookingAssertion.assertThat(actualBooking)
                .isOpen()
                .isHotelRoom()
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .containsAllDays(LocalDate.of(2020,3,4),
                        LocalDate.of(2020,3,5),
                        LocalDate.of(2020,3,6));

    }

}
