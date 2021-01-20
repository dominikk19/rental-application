package pl.dkiszka.rentalapplication.apartment.vo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 20.01.2021
 */
class ApartmentBookedEventTest {

    @Test
    void should_create_event_with_all_information() {
        var apartmentUuid = UUID.randomUUID().toString();
        var ownerId = UUID.randomUUID().toString();
        var tenantId = UUID.randomUUID().toString();

        var actualEvent = ApartmentBookedEvent.create(apartmentUuid, tenantId, ownerId, LocalDate.now().minusDays(10), LocalDate.now());
        assertThat(actualEvent.getEventId()).isNotEmpty();
        assertThat(actualEvent.getApartmentUuid()).isEqualTo(apartmentUuid);
        assertThat(actualEvent.getTenantId()).isEqualTo(tenantId);
    }
}
