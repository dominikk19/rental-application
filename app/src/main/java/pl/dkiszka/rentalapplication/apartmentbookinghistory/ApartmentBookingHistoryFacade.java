package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.vo.ApartmentBookedEvent;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@RequiredArgsConstructor
public class ApartmentBookingHistoryFacade {
    private final ApartmentBookingHistoryRepository apartmentBookingHistoryRepository;


    public void addBooking(ApartmentBookedEvent apartmentBookedEvent) {
        var apartment = findByApartmentUuid(apartmentBookedEvent.getApartmentUuid());
        apartment.ifPresentOrElse(it -> addApartmentBooking(ApartmentBookingHistory.restore(it), apartmentBookedEvent),
                () -> createNewBooking(apartmentBookedEvent));
    }


    private Optional<ApartmentBookingHistorySnapshot> findByApartmentUuid(String apartmentUuid) {
        return apartmentBookingHistoryRepository.findByApartmentUuid(apartmentUuid)
                .map(ApartmentBookingHistory::getSnapshot);
    }

    private void addApartmentBooking(ApartmentBookingHistory apartmentBookingHistory, ApartmentBookedEvent apartmentBookedEvent) {
        apartmentBookingHistory.addBooking(ApartmentBooking.start(
                apartmentBookedEvent.getEventCreationDataTime(),
                apartmentBookedEvent.getOwnerId(),
                apartmentBookedEvent.getTenantId(),
                apartmentBookedEvent.getStart(),
                apartmentBookedEvent.getEnd()));

        apartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }

    private void createNewBooking(ApartmentBookedEvent apartmentBookedEvent) {
        var apartmentBookingHistory = ApartmentBookingHistory.start(apartmentBookedEvent);
        apartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }


}
