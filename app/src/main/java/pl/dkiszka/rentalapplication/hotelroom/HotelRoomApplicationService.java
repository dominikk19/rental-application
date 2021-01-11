package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.eventchanel.DomainEventPublisher;
import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomBookingDto;
import pl.dkiszka.rentalapplication.hotelroom.dto.HotelRoomDto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelRoomApplicationService {

    private final HotelRoomRepository hotelRoomRepository;
    private final DomainEventPublisher domainEventPublisher;

    HotelRoomDto add(HotelRoomDto hotelRoomDto) {
        var hotelRoom = new HotelRoomFactory().create(hotelRoomDto);
        return HotelRoomDtoFactory.fromHotelRoom(hotelRoomRepository.save(hotelRoom));
    }

    void book(String id, HotelRoomBookingDto hotelRoomBookingDto) {
        var hotelRoom = hotelRoomRepository.findById(id);
        hotelRoom.ifPresent(it ->
                domainEventPublisher.publish(it.book(hotelRoomBookingDto.getTenantId(), hotelRoomBookingDto.getDays()))
        );
    }
}
