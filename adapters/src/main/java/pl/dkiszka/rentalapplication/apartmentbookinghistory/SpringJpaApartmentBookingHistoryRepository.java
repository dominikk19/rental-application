package pl.dkiszka.rentalapplication.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 11.01.2021
 */
interface SpringJpaApartmentBookingHistoryRepository extends Repository<SqlApartmentBookingHistory, String> {
    Optional<SqlApartmentBookingHistory> findByUuid(String uuid);

    SqlApartmentBookingHistory save(SqlApartmentBookingHistory sqlApartmentBookingHistory);
}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@org.springframework.stereotype.Repository
class JpaApartmentBookingHistoryRepository implements ApartmentBookingHistoryRepository {

    private final SpringJpaApartmentBookingHistoryRepository springJpaApartmentBookingHistoryRepository;

    @Override
    public Optional<ApartmentBookingHistory> findByApartmentUuid(String apartmentUuid) {
        return springJpaApartmentBookingHistoryRepository.findByUuid(apartmentUuid)
                .map(SqlApartmentBookingHistory::toApartmentBookingHistory);
    }

    @Override
    public ApartmentBookingHistory save(ApartmentBookingHistory apartmentBookingHistory) {
        return springJpaApartmentBookingHistoryRepository.save(SqlApartmentBookingHistory.from(apartmentBookingHistory))
                .toApartmentBookingHistory();
    }
}
