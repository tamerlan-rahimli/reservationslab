package org.myspringprogect.reservationslab.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.myspringprogect.reservationslab.model.enums.ReservationStatus;

import java.security.PrivilegedAction;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
@Entity
@Table(name="reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String tableName;
    private String customer;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private int membersCount;
}
