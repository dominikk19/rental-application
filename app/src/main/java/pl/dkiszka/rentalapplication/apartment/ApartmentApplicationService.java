package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentBookingDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
class ApartmentApplicationService {

    private final ApartmentRepository apartmentRepository;
    private final BookingRepository bookingRepository;
    private final DomainEventPublisher domainEventPublisher;

    ApartmentDto add(ApartmentDto apartmentDto) {
        var newApartment = new ApartmentFactory().fromDtoTo(apartmentDto);
        var savedApartment = apartmentRepository.save(newApartment);
        return ApartmentDtoFactory.fromApartment(savedApartment);
    }

    void book(String id, ApartmentBookingDto apartmentBookingDto) {
        var apartment = apartmentRepository.findById(id);
        apartment.ifPresent(it -> {
            var booking = it.book(apartmentBookingDto.getTenantId(), new Period(apartmentBookingDto.getStart(), apartmentBookingDto.getEnd()));
            domainEventPublisher.publish(it.bookedEvent(bookingRepository.save(booking)));
        });

    }
}

