package pl.dkiszka.rentalapplication.apartment;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 30.01.2021
 */
class ApartmentNotFoundException extends RuntimeException{
    public ApartmentNotFoundException(String message) {
        super(message);
    }
}
