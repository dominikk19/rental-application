package pl.dkiszka.rentalapplication.query.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.query.apartment.dto.ApartmentDetails;


/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 18.01.2021
 */

@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/v1/apartment")
class ApartmentQueryController {

    private final QueryApartmentRepository queryApartmentRepository;

    @GetMapping("/{id}")
    ResponseEntity<ApartmentDetails> findById(@PathVariable String id) {
        return ResponseEntity.ok(queryApartmentRepository.findById(id));
    }

    @ExceptionHandler(DataNotFoundException.class)
    ResponseEntity<String> handleClientError(DataNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
