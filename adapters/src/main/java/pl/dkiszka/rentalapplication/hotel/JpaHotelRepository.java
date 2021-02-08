package pl.dkiszka.rentalapplication.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
class JpaHotelRepository implements HotelRepository {

    private final SpringJpaHotelRepository springJpaHotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        var sqlHotel = SqlHotel.fromHotel(hotel);
        return springJpaHotelRepository.save(sqlHotel).toHotel();
    }

    @Override
    public Hotel findById(String hotelId) {
        return springJpaHotelRepository.findById(hotelId)
                .map(SqlHotel::toHotel)
                .orElseThrow(() -> new HotelNotFoundException(String.format("Hotel by id %s not found", hotelId)));
    }
}


interface SpringJpaHotelRepository extends Repository<SqlHotel, String> {
    SqlHotel save(SqlHotel hotel);

    Optional<SqlHotel> findById(String id);
}
