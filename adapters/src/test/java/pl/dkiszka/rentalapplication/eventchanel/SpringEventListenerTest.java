package pl.dkiszka.rentalapplication.eventchanel;

import org.junit.jupiter.api.Test;
import pl.dkiszka.rentalapplication.apartmentbookinghistory.ApartmentBookingHistoryFacade;
import pl.dkiszka.rentalapplication.hotelbookinghistory.HotelBookingHistoryFacade;

import static org.mockito.Mockito.mock;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 27.01.2021
 */
class SpringEventListenerTest {
    private final HotelBookingHistoryFacade hotelBookingHistoryFacade = mock(HotelBookingHistoryFacade.class);
    private final ApartmentBookingHistoryFacade apartmentBookingHistoryFacade = mock(ApartmentBookingHistoryFacade.class);
    private final SpringEventListener springEventListener = new SpringEventListener(hotelBookingHistoryFacade, apartmentBookingHistoryFacade);

    @Test
    void consume() {

    }
}
