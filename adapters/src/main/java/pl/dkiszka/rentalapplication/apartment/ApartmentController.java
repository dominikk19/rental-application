package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentBookingDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentReadModel;

import java.net.URI;
import java.util.List;

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
    private final ApartmentQueryRepository apartmentQueryRepository;


    @PostMapping
    ResponseEntity<ApartmentDto> addApartment(@RequestBody ApartmentDto apartmentDto) {
        var apartment = apartmentApplicationService.add(apartmentDto);
        return ResponseEntity
                .created(URI.create("/" + apartment.getId()))
                .body(apartment);
    }

    @PutMapping("/book/{id}")
    void book(@PathVariable String id, @RequestBody ApartmentBookingDto apartmentBookingDto) {
        apartmentApplicationService.book(id, apartmentBookingDto);
    }

    @GetMapping()
    ResponseEntity<List<ApartmentReadModel>> findAll() {
        var apartments = apartmentQueryRepository.findDtoAllBy();
        return ResponseEntity.ok(apartments);
    }


}
