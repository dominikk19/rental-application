package pl.dkiszka.rentalapplication.hotel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 08.02.2021
 */
class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String message) {
        super(message);
    }
}
