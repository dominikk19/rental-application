package pl.dkiszka.rentalapplication.booking;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
interface CommandRegistry {
    void register(String id);

    void accept(String id);
}
