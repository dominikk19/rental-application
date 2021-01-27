package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentBookingDto;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.booking.BookingFacade;
import pl.dkiszka.rentalapplication.booking.vo.SimpleBooking;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */
class ApartmentApplicationServiceTest {

    private ApartmentRepository apartmentRepository = Mockito.mock(ApartmentRepository.class);
    private BookingFacade bookingFacade = Mockito.mock(BookingFacade.class);
    private DomainEventPublisher domainEventPublisher = Mockito.mock(DomainEventPublisher.class);

    private ApartmentApplicationService apartmentApplicationService = new ApartmentApplicationService(apartmentRepository, bookingFacade, domainEventPublisher);


    @Test
    void when_book_apartment_then_should_be_publish_event() {
        var argumentCaptor = ArgumentCaptor.forClass(ApartmentBookedEvent.class);
        var apartmentUuid = UUID.randomUUID().toString();

        var tenantId = UUID.randomUUID().toString();
        var startDate = LocalDate.now().plusDays(6);
        var endDate = LocalDate.now().plusDays(10);

        var apartmentBookingDto = new ApartmentBookingDto(tenantId, startDate, endDate);

        given(apartmentRepository.findById(apartmentUuid)).willReturn(Optional.of(createApartment(apartmentUuid)));
        given(bookingFacade.bookApartment(apartmentUuid, tenantId, Lists.newArrayList(startDate, endDate))).willReturn(new SimpleBooking(UUID.randomUUID().toString()));

        apartmentApplicationService.book(apartmentUuid, apartmentBookingDto);

        BDDMockito.then(domainEventPublisher).should().publish(argumentCaptor.capture());

        var actual = argumentCaptor.getValue();
        Assertions.assertThat(actual.getApartmentUuid()).isEqualTo(apartmentUuid);
        Assertions.assertThat(actual.getTenantId()).isEqualTo(tenantId);
        Assertions.assertThat(actual.getStart()).isEqualTo(startDate);

    }


    static Apartment createApartment(String apartmentUuid) {
        var addressSnapshot = AddressSnapshot.
                builder()
                .country("Poland")
                .city("Warsaw")
                .street("Polna")
                .postalCode("00-001")
                .houseNumber("1")
                .apartmentNumber("1")
                .build();
        return Apartment.restore(new ApartmentSnapshot(apartmentUuid, "999", addressSnapshot,
                Lists.newArrayList(new RoomSnapshot("", "salon", 35.00)),
                "small apartment",
                Lists.newArrayList())
        );

    }
}
