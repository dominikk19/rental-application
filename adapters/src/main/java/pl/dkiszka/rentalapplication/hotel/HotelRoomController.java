package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.hotel.dto.HotelRoomBookingDto;
import pl.dkiszka.rentalapplication.hotel.dto.RoomDto;

import java.net.URI;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */


@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/v1/hotel")
class HotelRoomController {

    private final HotelApplicationService hotelApplicationService;

    @PostMapping(path = "/{hotelId}/room")
    public ResponseEntity<RoomDto> addApartment(@PathVariable String hotelId, @RequestBody RoomDto roomDto) {
        var hotelRoom = hotelApplicationService.add(hotelId, roomDto);
        return ResponseEntity
                .created(URI.create("/" + hotelRoom.getId()))
                .body(hotelRoom);
    }

    @PutMapping("/book/{id}")
    public void book(@PathVariable String id, @RequestBody HotelRoomBookingDto hotelRoomBookingDto){
        hotelApplicationService.book(id, hotelRoomBookingDto);

    }


}
