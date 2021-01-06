package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 06.01.2021
 */

@org.springframework.stereotype.Repository
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class JpaHotelRoomRepository implements HotelRoomRepository {
    private final SpringJpaHotelRoomRepository springJpaHotelRoomRepository;


    @Override
    public void save(HotelRoom hotelRoom) {
        var sqlHotelRoom = SqlHotelRoom.fromHotelRoom(hotelRoom);
        springJpaHotelRoomRepository.save(sqlHotelRoom);
    }
}


interface SpringJpaHotelRoomRepository extends Repository<SqlHotelRoom, String> {
    SqlHotelRoom save(SqlHotelRoom hotelRoom);
}
