package pl.dkiszka.rentalapplication.booking;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class BookingTest {

    private final String RENTAL_PLACE_ID = "567";
    private final String TENANT_ID = "12344567";

    @Test
    void should_create_booking_for_apartment() {

        var days = Lists.newArrayList(LocalDate.of(2020, 3, 4),
                LocalDate.of(2020, 3, 5),
                LocalDate.of(2020, 3, 6));

        var actualBooking = prepareApartmentBooking(days);

        BookingAssertion.assertThat(actualBooking)
                .isOpen()
                .isApartment()
                .hasRentalPlaceIdEqualTo(RENTAL_PLACE_ID)
                .hasTenantIdEqualTo(TENANT_ID)
                .containsAllDays(LocalDate.of(2020, 3, 6),
                        LocalDate.of(2020, 3, 5),
                        LocalDate.of(2020, 3, 4));
    }


    @Test
    void should_create_booking_for_hotel_room() {

        var days = Lists.newArrayList(LocalDate.of(2020, 3, 4),
                LocalDate.of(2020, 3, 5),
                LocalDate.of(2020, 3, 6));

        var actualBooking = prepareHotelBooking(days);

        BookingAssertion.assertThat(actualBooking)
                .isOpen()
                .isHotelRoom()
                .hasRentalPlaceIdEqualTo(RENTAL_PLACE_ID)
                .hasTenantIdEqualTo(TENANT_ID)
                .containsAllDays(LocalDate.of(2020, 3, 4),
                        LocalDate.of(2020, 3, 5),
                        LocalDate.of(2020, 3, 6));

    }

    @Test
    void when_accepted_booking_then_booking_accepted_event_should_be_created() {
        var days = Lists.newArrayList(LocalDate.of(2020, 3, 4),
                LocalDate.of(2020, 3, 5),
                LocalDate.of(2020, 3, 6));

        var actualBookingAcceptedEvent = prepareHotelBooking(days).accept();

        Assertions.assertThat(actualBookingAcceptedEvent)
                .hasFieldOrPropertyWithValue("rentalType", RentalType.HOTEL_ROOM.name())
                .hasFieldOrPropertyWithValue("rentalPlaceId", RENTAL_PLACE_ID)
                .hasFieldOrPropertyWithValue("tenantId", TENANT_ID);
    }

    @Test
    void when_accepted_booking_then_status_should_be_accept() {
        var days = Lists.newArrayList(LocalDate.of(2020, 3, 4),
                LocalDate.of(2020, 3, 5),
                LocalDate.of(2020, 3, 6));

        var actualBooking = prepareHotelBooking(days);
        actualBooking.accept();

        BookingAssertion.assertThat(actualBooking)
                .isAccept();
    }

    private Booking prepareHotelBooking(List<LocalDate> days) {
        return Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, days);
    }

    private Booking prepareApartmentBooking(List<LocalDate> days) {
        return Booking.apartment(RENTAL_PLACE_ID, TENANT_ID, days);
    }


}
