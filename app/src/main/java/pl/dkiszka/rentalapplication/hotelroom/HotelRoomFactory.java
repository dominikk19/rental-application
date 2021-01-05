package pl.dkiszka.rentalapplication.hotelroom;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 26.12.2020
 */
public class HotelRoomFactory {
    public HotelRoom create(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        List<Space> speces = spacesDefinition.entrySet()
                .stream()
                .map(entry->{
                    var sq = new SquareMater(entry .getValue());
                    return new Space(entry.getKey(), sq);
                })
                .collect(toList());

        return new HotelRoom(hotelId, number, speces, description);
    }
}
