package pl.dkiszka.rentalapplication.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class BookingController {
    private final CommandRegistry commandRegistry;


    @PutMapping("/reject/{id}")
    void reject(String id){
        commandRegistry.register(id);
    }
}
