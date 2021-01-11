package pl.dkiszka.rentalapplication.eventchanel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;
import pl.dkiszka.rentalapplication.apartmentbookinghistory.ApartmentBookingHistoryFacade;
import pl.dkiszka.rentalapplication.hotelbookinghistory.HotelBookingHistoryFacade;
import pl.dkiszka.rentalapplication.hotelroom.vo.HotelRoomBookedEvent;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 09.01.2021
 */
@RequiredArgsConstructor
class SpringEventListener {
    private final HotelBookingHistoryFacade hotelBookingHistoryFacade;
    private final ApartmentBookingHistoryFacade apartmentBookingHistoryFacade;


    @EventListener
    public void consume(ApartmentBookedEvent apartmentBookedEvent) {
        apartmentBookingHistoryFacade.addBooking(apartmentBookedEvent);
    }


    @EventListener
    public void consume(HotelRoomBookedEvent hotelRoomBookedEvent) {
        hotelBookingHistoryFacade.addBooking(hotelRoomBookedEvent);
    }


}
