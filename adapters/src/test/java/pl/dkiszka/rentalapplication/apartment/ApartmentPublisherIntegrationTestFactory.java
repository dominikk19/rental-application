package pl.dkiszka.rentalapplication.apartment;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 30.01.2021
 */

@Component
public class ApartmentPublisherIntegrationTestFactory {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    public void publishApartmentBookedEvent(String uuid, String ownerId, String tenantId, LocalDate startDate, LocalDate endDate) {
        var apartment = prepareApartment(uuid, ownerId);
        var event = apartmentRepository.save(apartment).bookedEvent(tenantId, new Period(startDate, endDate));

        publisher.publishEvent(event);
    }

    private Apartment prepareApartment(String uuid, String ownerId) {
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
            return Apartment.restore(new ApartmentSnapshot(null, uuid, ownerId, addressSnapshot,
                    Lists.newArrayList(new RoomSnapshot(null, UUID.randomUUID().toString(), "salon", 35.00)),
                    "small apartment",
                    Lists.newArrayList()));
        }
    }

}
