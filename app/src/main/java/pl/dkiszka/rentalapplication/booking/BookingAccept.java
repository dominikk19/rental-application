package pl.dkiszka.rentalapplication.booking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 17.01.2021
 */
@RequiredArgsConstructor
@Getter
class BookingAccept {
    private final String bookingId;
}
