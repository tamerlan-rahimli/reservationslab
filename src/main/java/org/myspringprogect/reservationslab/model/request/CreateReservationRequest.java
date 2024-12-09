package org.myspringprogect.reservationslab.model.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myspringprogect.reservationslab.model.enums.ReservationStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    private String tableName;
    private String customer;
    private int membersCount;
}
