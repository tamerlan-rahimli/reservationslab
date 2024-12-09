package org.myspringprogect.reservationslab.dao.repository;

import org.myspringprogect.reservationslab.dao.entity.ReservationEntity;
import org.myspringprogect.reservationslab.model.enums.ReservationStatus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<ReservationEntity,Long> {
    Optional<ReservationEntity> findByIdAndStatusNot(Long id, ReservationStatus status);
    Optional<ReservationEntity> findByTableNameAndStatusNot(String tableName, ReservationStatus status);
    List<ReservationEntity> findByStatusAndReservationDateBetween(
            ReservationStatus status,
            LocalDate startDate,
            LocalDate endDate);
}
