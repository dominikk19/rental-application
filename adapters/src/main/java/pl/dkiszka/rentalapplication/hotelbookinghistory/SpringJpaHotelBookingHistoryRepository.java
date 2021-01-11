package pl.dkiszka.rentalapplication.hotelbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
interface SpringJpaHotelBookingHistoryRepository extends Repository<SqlHotelBookingHistory, String> {
}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@org.springframework.stereotype.Repository
class JpaHotelBookingHistoryRepository implements HotelBookingHistoryRepository {
    private final SpringJpaHotelBookingHistoryRepository springJpaHotelBookingHistoryRepository;

    @Override
    public Optional<HotelBookingHistory> findByHotelId(String hotelId) {
        return Optional.empty();
    }

    @Override
    public HotelBookingHistory save(HotelBookingHistory hotelBookingHistory) {
        return null;
    }
}
