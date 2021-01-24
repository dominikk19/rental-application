package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import pl.dkiszka.rentalapplication.apartment.dto.AddressDto;
import pl.dkiszka.rentalapplication.apartment.dto.ApartmentDto;
import pl.dkiszka.rentalapplication.apartment.dto.RoomDto;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 24.01.2021
 */

class ApartmentFactoryTest {

    private final ApartmentFactory apartmentFactory = new ApartmentFactory();


    @Test
    void should_create_apartment_with_all_required_fields() {
        var ownerId = UUID.randomUUID().toString();
        var city = "Warsaw";
        var addressDto = new AddressDto("Poland",
                city,
                "Polna",
                "00-001",
                "1a",
                "1");
        var roomsDto = Lists.newArrayList(new RoomDto("0", "salon", 23.5));


        var apartmentDto = new ApartmentDto("0", ownerId, addressDto, roomsDto, "Small apartment");

        var apartment = apartmentFactory.fromDtoTo(apartmentDto);

        assertThatHasOwnerId(apartment, ownerId);
        assertThatHasAddress(apartment, city);
        assertThatHasRooms(apartment, roomsDto);

    }

    private void assertThatHasOwnerId(Apartment actual, String ownerId) {
        assertThat(actual).hasFieldOrPropertyWithValue("ownerId", ownerId);
    }

    private void assertThatHasAddress(Apartment actual, String city) {
        assertThat(actual).extracting("address")
                .hasFieldOrPropertyWithValue("city", city);
    }

    private void assertThatHasRooms(Apartment actual, List<RoomDto> roomsDto) {
        assertThat(actual).extracting("rooms")
                .satisfies(roomsActual -> {
                    var rooms = (List<Room>) roomsActual;
                    assertThat(rooms).hasSize(roomsDto.size());

                    roomsDto.forEach(
                            (roomDto) -> {
                                assertThat(rooms).anySatisfy(room -> {
                                    assertThat(room).hasFieldOrPropertyWithValue("name", roomDto.getName());
                                });
                            }
                    );
                });
    }
}
