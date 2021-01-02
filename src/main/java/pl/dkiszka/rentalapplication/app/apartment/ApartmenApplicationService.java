package pl.dkiszka.rentalapplication.app.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.app.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentFactory;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
@RequiredArgsConstructor
public class ApartmenApplicationService {

    private final ApartmentRepository apartmentRepository;
    
    public void add(String ownerId, ApartmentDto apartmentDto) {
        var newApartment = new ApartmentFactory().fromTo(ownerId, apartmentDto);
        apartmentRepository.save(newApartment);

    }
}
