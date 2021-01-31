package pl.dkiszka.rentalapplication.eventchanel;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.dkiszka.rentalapplication.apartment.ApartmentPublisherIntegrationTestFactory;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.time.LocalDate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 27.01.2021
 */
@SpringBootTest
class SpringEventListenerIntegrationTest {

    private final String APARTMENT_UUID = "12345";
    private final String OWNER_ID = "12123";
    private final String TENANT_ID = "99999";
    private final LocalDate START_DATE = LocalDate.now().plusDays(5);
    private final LocalDate END_DATE = LocalDate.now().plusDays(8);

    @Autowired
    ApartmentPublisherIntegrationTestFactory apartmentPublisherIntegrationTestFactory;

    @MockBean
    private SpringEventListener springEventListener;

    @Test
    void when_publish_apartment_booked_event_then_event_should_be_consume() {
        ArgumentCaptor<ApartmentBookedEvent> captor = ArgumentCaptor.forClass(ApartmentBookedEvent.class);
        apartmentPublisherIntegrationTestFactory.publishApartmentBookedEvent(APARTMENT_UUID, OWNER_ID, TENANT_ID, START_DATE, END_DATE);

        verify(springEventListener, times(1)).consume(captor.capture());
    }
}
