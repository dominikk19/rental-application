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
    public Hotel save(Hotel hotel) {
        var sqlHotel = SqlHotel.fromHotel(hotel);
        return springJpaHotelRepository.save(sqlHotel).toHotel();
    }
}


interface SpringJpaHotelRepository extends Repository<SqlHotel, String> {
    SqlHotel save(SqlHotel hotel);
}
