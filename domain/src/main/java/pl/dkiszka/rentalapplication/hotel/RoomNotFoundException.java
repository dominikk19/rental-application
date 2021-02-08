package pl.dkiszka.rentalapplication.hotel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.02.2021
 */
class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message) {
        super(message);
    }
}
