package pl.dkiszka.rentalapplication.app.apartment;

import pl.dkiszka.rentalapplication.app.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 22.12.2020
 */
public class ApartmenApplicationService {

    public void add(String ownerId, ApartmentDto apartmentDto){
        var newApartment = Apartment.fromTo(ownerId,apartmentDto);
    }
}
