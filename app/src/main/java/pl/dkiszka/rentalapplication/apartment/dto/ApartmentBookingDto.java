package pl.dkiszka.rentalapplication.apartment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project rental-application
 * @date 07.01.2021
 */
@AllArgsConstructor
@Getter
public class ApartmentBookingDto {
    private String tenantId;
    private LocalDate start;
    private LocalDate end;


}
