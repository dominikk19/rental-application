package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomBookingDto;
import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomDto;

import java.net.URI;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */


@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/v1/hotel-room")
class HotelRoomController {

    private final HotelRoomApplicationService hotelRoomApplicationService;

    @PostMapping
    public ResponseEntity<HotelRoomDto> addApartment(@RequestBody HotelRoomDto hotelRoomDto) {
        var hotelRoom = hotelRoomApplicationService.add(hotelRoomDto);
        return ResponseEntity
                .created(URI.create("/" + hotelRoom.getId()))
                .body(hotelRoom);
    }

    @PutMapping("/book/{id}")
    public void book(@PathVariable String id, @RequestBody HotelRoomBookingDto hotelRoomBookingDto){
        hotelRoomApplicationService.book(id, hotelRoomBookingDto);

    }


}
