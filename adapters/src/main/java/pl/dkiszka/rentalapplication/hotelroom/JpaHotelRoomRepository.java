package pl.dkiszka.rentalapplication.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

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
    public HotelRoom save(HotelRoom hotelRoom) {
        var sqlHotelRoom = SqlHotelRoom.fromHotelRoom(hotelRoom);
        return springJpaHotelRoomRepository.save(sqlHotelRoom).toHotelRoom();
    }

    @Override
    public Optional<HotelRoom> findById(String id) {
        return springJpaHotelRoomRepository.findById(id)
                .map(SqlHotelRoom::toHotelRoom);
    }
}


interface SpringJpaHotelRoomRepository extends Repository<SqlHotelRoom, String> {
    SqlHotelRoom save(SqlHotelRoom hotelRoom);

    Optional<SqlHotelRoom> findById(String id);
}
