package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 30.01.2021
 */
@SpringBootTest
class JpaApartmentRepositoryIntegrationTest {

    private final String APARTMENT_UUID = "12345";
    private final String OWNER_ID = "12123";

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Test
    void when_save_apartment_then_apartment_should_be_saved() {
        var actualSavedApartment = apartmentRepository.save(prepareApartment());
        org.assertj.core.api.Assertions.assertThat(actualSavedApartment)
                .hasFieldOrPropertyWithValue("uuid", APARTMENT_UUID)
                .hasFieldOrPropertyWithValue("ownerId", OWNER_ID);
    }

    @Test
    void when_apartment_saved_then_should_be_found() {
        var actualSavedApartment = apartmentRepository.save(prepareApartment());

        var actualApartment = apartmentRepository.findById(actualSavedApartment.getSnapshot().getId()).orElse(null);

        org.assertj.core.api.Assertions.assertThat(actualApartment)
                .hasFieldOrPropertyWithValue("uuid", APARTMENT_UUID)
                .hasFieldOrPropertyWithValue("ownerId", OWNER_ID);
    }

    @Test
    void when_find_apartment_by_id_then_should_throw_ApartmentNotFoundException() {
        Assertions.assertThrows(ApartmentNotFoundException.class, () -> apartmentRepository.findById("123"));
    }

    private Apartment prepareApartment() {
        {
            var addressSnapshot = AddressSnapshot.
                    builder()
                    .country("Poland")
                    .city("Warsaw")
                    .street("Polna")
                    .postalCode("00-001")
                    .houseNumber("1")
                    .apartmentNumber("1")
                    .build();
            return Apartment.restore(new ApartmentSnapshot(null, APARTMENT_UUID, OWNER_ID, addressSnapshot,
                    Lists.newArrayList(new RoomSnapshot(null, UUID.randomUUID().toString(), "salon", 35.00)),
                    "small apartment",
                    Lists.newArrayList()));
        }
    }


}
