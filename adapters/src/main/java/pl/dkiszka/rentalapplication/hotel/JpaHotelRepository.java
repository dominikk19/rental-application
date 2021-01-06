package pl.dkiszka.rentalapplication.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

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
    public void save(Hotel hotel) {
        var sqlHotel = SqlHotel.fromHotel(hotel);
        springJpaHotelRepository.save(sqlHotel);
    }
}


interface SpringJpaHotelRepository extends Repository<SqlHotel, String> {
    SqlHotel save(SqlHotel hotel);
}
