package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 27.01.2021
 */
class ApartmentBookingHistoryFacadeTest {


    private static final String APARTMENT_ID = UUID.randomUUID().toString();
    private static final String TENANT_ID = UUID.randomUUID().toString();
    private static final String OWNER_ID = UUID.randomUUID().toString();
    private static final LocalDate START_DAY = LocalDate.now().plusDays(2);
    private static final LocalDate END_DAY = LocalDate.now().plusDays(3);

    private final ApartmentBookingHistoryRepository repository = mock(ApartmentBookingHistoryRepository.class);
    private final ApartmentBookingHistoryFacade apartmentBookingHistoryFacade = new ApartmentBookingHistoryFacade(repository);


    @Test
    void when_given_apartment_booked_event_then_apartment_booking_history_should_be_create_and_saved() {
        var apartmentBookingHistoryCapture = ArgumentCaptor.forClass(ApartmentBookingHistory.class);
        var apartmentBookedEvent = createApartmentBookedEvent(APARTMENT_ID, TENANT_ID, OWNER_ID, START_DAY, END_DAY);

        when(repository.findByApartmentUuid(APARTMENT_ID)).thenReturn(Optional.empty());

        apartmentBookingHistoryFacade.addBooking(apartmentBookedEvent);

        BDDMockito.then(repository).should().save(apartmentBookingHistoryCapture.capture());
        thenApartmentBookingHistoryShouldHave(apartmentBookingHistoryCapture.getValue(), APARTMENT_ID);
        thenApartmentBookingShouldContainOneApartmentBooking(apartmentBookingHistoryCapture.getValue(), TENANT_ID, OWNER_ID, START_DAY, END_DAY);

    }

    private ApartmentBookedEvent createApartmentBookedEvent(String apartmentUuid, String tenantId, String ownerId, LocalDate start, LocalDate end) {
        return ApartmentBookedEvent.create(apartmentUuid, tenantId, ownerId, start, end);
    }

    private void thenApartmentBookingHistoryShouldHave(ApartmentBookingHistory actual, String apartmentUuid) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("apartmentUuid", apartmentUuid);
    }


    private void thenApartmentBookingShouldContainOneApartmentBooking(ApartmentBookingHistory actual, String tenantId, String ownerId, LocalDate start, LocalDate end) {
        Assertions.assertThat(actual).extracting("bookings")
                .satisfies(booking -> {
                    var bookings = (List<ApartmentBooking>) booking;
                    Assertions.assertThat(bookings)
                            .hasSize(1)
                            .allSatisfy(
                                    book->{
                                    Assertions.assertThat(book).hasFieldOrPropertyWithValue("tenantId", tenantId)
                                            .hasFieldOrPropertyWithValue("ownerId", ownerId)
                                            .hasFieldOrPropertyWithValue("periodStart", start)
                                            .hasFieldOrPropertyWithValue("periodEnd", end);
                                    }
                            );

                });
    }
    //todo dokończyc testy Double patterns
}
