package pl.dkiszka.rentalapplication.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.booking.BookingFacade;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;
import pl.dkiszka.rentalapplication.hotel.dto.HotelDto;
import pl.dkiszka.rentalapplication.hotel.dto.HotelRoomBookingDto;
import pl.dkiszka.rentalapplication.hotel.dto.RoomDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelApplicationService {

    private final HotelRepository hotelRepository;
    private final BookingFacade bookingFacade;
    private final DomainEventPublisher domainEventPublisher;

    HotelDto add(HotelDto hotelDto) {
        var hotel = new HotelFactory().create(hotelDto);
        return HotelDtoFactory.fromHotel(hotelRepository.save(hotel));
    }

    RoomDto add(String hotelId, RoomDto roomDto) {
        var hotel = hotelRepository.findById(hotelId);
        hotel.addRoom(new HotelRoomFactory().create(roomDto));
        return hotelRepository.save(hotel)
                .toSnapshot()
                .getRooms()
                .stream()
                .filter(room -> room.getNumber() == roomDto.getNumber())
                .findFirst()
                .map(HotelRoomDtoFactory::fromHotelRoom)
                .orElseThrow();
    }

    void book(String hotelId, HotelRoomBookingDto hotelRoomBookingDto) {
        var hotel = hotelRepository.findById(hotelId);

        var room = hotel.roomByRoomId(hotelRoomBookingDto.getRoomId());

        var hotelRoomSnapshot = room.toSnapshot();

        var booking = bookingFacade.bookHotelRoom(hotel.toSnapshot().getId(),
                hotelRoomBookingDto.getTenantId(),
                hotelRoomBookingDto.getDays());

        room.addBooking(booking);

        domainEventPublisher.publish(room.bookedEvent(hotel.toSnapshot().getId(), hotelRoomBookingDto.getTenantId(), hotelRoomBookingDto.getDays()));
    }

}
