package pl.dkiszka.rentalapplication.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
class ApartmentApplicationService {

    private final ApartmentRepository apartmentRepository;

    public void add(String ownerId, ApartmentDto apartmentDto) {
        var newApartment = new ApartmentFactory().fromTo(ownerId, apartmentDto);
        apartmentRepository.save(newApartment);
    }
}
