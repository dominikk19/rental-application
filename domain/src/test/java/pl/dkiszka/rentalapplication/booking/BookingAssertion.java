package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class BookingAssertion {

    private final Booking actual;

    static BookingAssertion assertThat(Booking actualBooking) {
        return new BookingAssertion(actualBooking);
    }

    BookingAssertion isOpen() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus", BookingStatus.OPEN);
        return this;

    }

    BookingAssertion isAccept() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus", BookingStatus.ACCEPT);
        return this;

    }

    public BookingAssertion isApartment() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.APARTMENT);
        return this;
    }

    BookingAssertion isHotelRoom() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.HOTEL_ROOM);
        return this;

    }

    BookingAssertion hasRentalPlaceIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", expected);
        return this;

    }

    BookingAssertion hasTenantIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;

    }

    BookingAssertion containsAllDays(LocalDate... expected) {
        Assertions.assertThat(actual)
                .extracting("days").satisfies(actualDays -> {
            var days = (List<BookingDay>) actualDays;

            asList(expected).forEach(
                    (actualDate) -> {
                        Assertions.assertThat(days)
                                .anySatisfy(day -> {
                                    Assertions.assertThat(day).hasFieldOrPropertyWithValue("day", actualDate);
                                });
                    }
            );
        });
        return this;
    }


}
