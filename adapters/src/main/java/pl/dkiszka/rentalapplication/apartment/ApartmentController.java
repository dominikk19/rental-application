package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;

import java.net.URI;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/v1/apartment")
class ApartmentController {

    private final ApartmentApplicationService apartmentApplicationService;


    @PostMapping
    public ResponseEntity<ApartmentDto> addApartment(@RequestBody ApartmentDto apartmentDto) {
        var apartment = apartmentApplicationService.add(apartmentDto);
        return ResponseEntity
                .created(URI.create("/" + apartment.getId()))
                .body(apartment);
    }


}
