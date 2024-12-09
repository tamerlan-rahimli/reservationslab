package org.myspringprogect.reservationslab.model.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myspringprogect.reservationslab.model.enums.ReservationStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetReservationResponse {
    private String tableName;
    private String customer;
    private LocalDate date;
    private ReservationStatus status;
    private int membersCount;
}
