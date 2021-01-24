package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBookingAssertion {
    private final ApartmentBooking actual;

    static ApartmentBookingAssertion assertThat(ApartmentBooking actualApartmentBooking) {
        return new ApartmentBookingAssertion(actualApartmentBooking);
    }

    ApartmentBookingAssertion hasBookingDateTime(LocalDateTime expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingDataTime", expected);
        return this;
    }

    ApartmentBookingAssertion hasOwnerIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    ApartmentBookingAssertion hasTenatIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    ApartmentBookingAssertion hasBookingPeriodThatHas(LocalDate expectedStart, LocalDate expectedEnd) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("periodStart", expectedStart);
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("periodEnd", expectedEnd);
        return this;
    }
}
