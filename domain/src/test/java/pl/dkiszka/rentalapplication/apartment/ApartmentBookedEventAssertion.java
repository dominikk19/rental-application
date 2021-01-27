package pl.dkiszka.rentalapplication.apartment;

import org.assertj.core.api.Assertions;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class ApartmentBookedEventAssertion {

    static ApartmentBookedEventAssertion assertThat(ApartmentBookedEvent actualBookedEvent) {
        return new ApartmentBookedEventAssertion(actualBookedEvent);
    }

    private final ApartmentBookedEvent actualBookedEvent;


    private ApartmentBookedEventAssertion(ApartmentBookedEvent actualBookedEvent) {
        this.actualBookedEvent = actualBookedEvent;
    }

    ApartmentBookedEventAssertion hasOwnerIdEqualsTo(String expected) {
        Assertions.assertThat(actualBookedEvent).hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    ApartmentBookedEventAssertion hasTenantIdEqualsTo(String expected) {
        Assertions.assertThat(actualBookedEvent).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    ApartmentBookedEventAssertion hasPeriodContainsStartDay(LocalDate expected) {
        Assertions.assertThat(actualBookedEvent).hasFieldOrPropertyWithValue("start", expected);
        return this;
    }

    ApartmentBookedEventAssertion hasPeriodContainsEndDay(LocalDate expected) {
        Assertions.assertThat(actualBookedEvent).hasFieldOrPropertyWithValue("end", expected);
        return this;
    }


}
