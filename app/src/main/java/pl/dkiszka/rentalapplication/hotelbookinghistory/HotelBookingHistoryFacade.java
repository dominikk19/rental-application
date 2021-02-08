package pl.dkiszka.rentalapplication.hotelbookinghistory;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelBookingHistorySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingDaySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingHistorySnapshot;
import pl.dkiszka.rentalapplication.hotelbookinghistory.vo.HotelRoomBookingSnapshot;
import pl.dkiszka.rentalapplication.hotel.vo.HotelRoomBookedEvent;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 10.01.2021
 */
@RequiredArgsConstructor
public class HotelBookingHistoryFacade {
    private final HotelBookingHistoryRepository hotelBookingHistoryRepository;


    public void addBooking(HotelRoomBookedEvent hotelRoomBookedEvent) {
        var hotelBookHistorySnapshot = findByHotelId(hotelRoomBookedEvent.getHotelId());

        hotelBookHistorySnapshot.ifPresentOrElse(it -> add(it, hotelRoomBookedEvent),
                () -> createNewHotelBooking(hotelRoomBookedEvent)

        );

    }

    private Optional<HotelBookingHistorySnapshot> findByHotelId(String hotelId) {
        return hotelBookingHistoryRepository.findByHotelId(hotelId)
                .map(HotelBookingHistory::getSnapshot);
    }

    private void add(HotelBookingHistorySnapshot hotelBookingHistorySnapshot, HotelRoomBookedEvent hotelRoomBookedEvent) {
        var hotelBookingHistory = HotelBookingHistory.restore(hotelBookingHistorySnapshot);
        hotelBookingHistory.addBooking(hotelRoomBookedEvent.getHotelRoomId(),
                hotelRoomBookedEvent.getEventCreationDataTime(),
                hotelRoomBookedEvent.getTenantId(),
                hotelRoomBookedEvent.getDays());
        hotelBookingHistoryRepository.save(hotelBookingHistory);
    }


    private void createNewHotelBooking(HotelRoomBookedEvent hotelRoomBookedEvent) {
        var days = hotelRoomBookedEvent.getDays().stream()
                .map(it -> new HotelRoomBookingDaySnapshot(Strings.EMPTY, it))
                .collect(Collectors.toList());
        var hotelRoomBookingSnapshot = new HotelRoomBookingSnapshot(Strings.EMPTY, hotelRoomBookedEvent.getEventCreationDataTime(),
                hotelRoomBookedEvent.getTenantId(), days
        );

        var hotelRoomBookingHistorySnapshot = new HotelRoomBookingHistorySnapshot(hotelRoomBookedEvent.getHotelRoomId(), Lists.newArrayList(hotelRoomBookingSnapshot));
        var hotelBookingHistory = HotelBookingHistory.restore(new HotelBookingHistorySnapshot(hotelRoomBookedEvent.getHotelId(), Lists.newArrayList(hotelRoomBookingHistorySnapshot)));
        hotelBookingHistoryRepository.save(hotelBookingHistory);


    }


}



