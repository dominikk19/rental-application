package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentBookingDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.booking.BookingFacade;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
class ApartmentApplicationService {

    private final ApartmentRepository apartmentRepository;
    private final BookingFacade bookingFacade;
    private final DomainEventPublisher domainEventPublisher;

    ApartmentDto add(ApartmentDto apartmentDto) {
        var newApartment = new ApartmentFactory().fromDtoTo(apartmentDto);
        var savedApartment = apartmentRepository.save(newApartment);
        return ApartmentDtoFactory.fromApartment(savedApartment);
    }

    void book(String id, ApartmentBookingDto apartmentBookingDto) {
        var apartment = apartmentRepository.findById(id);
        var period = new Period(apartmentBookingDto.getStart(), apartmentBookingDto.getEnd());
        apartment.ifPresent(it -> {
            var apartmentSnapshot = it.getSnapshot();
            var booking = bookingFacade.bookApartment(apartmentSnapshot.getUuid(),
                    apartmentBookingDto.getTenantId(),
                    period.asDays());
            apartmentRepository.save(it.addBooking(booking));
            domainEventPublisher.publish(it.bookedEvent(apartmentBookingDto.getTenantId(), period));
        });

    }
}

