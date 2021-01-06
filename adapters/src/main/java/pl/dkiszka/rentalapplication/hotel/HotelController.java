package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.hotel.dto.HotelDto;

import java.net.URI;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */

@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/v1/hotel")
class HotelController {

    private final HotelApplicationService hotelApplicationService;


    @PostMapping
    public ResponseEntity<HotelDto> addHotel(@RequestBody HotelDto hotelDto) {
        var hotel = hotelApplicationService.add(hotelDto);
        return ResponseEntity
                .created(URI.create("/" + hotel.getId()))
                .body(hotel);
    }
}
