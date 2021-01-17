package pl.dkiszka.rentalapplication.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 13.01.2021
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class BookingSnapshot {
    private String id;
    private String uuid;
    private String apartmentId;
    private String tenantId;
    private PeriodSnapshot period;
}
