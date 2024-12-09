package org.myspringprogect.reservationslab.service;

import org.myspringprogect.reservationslab.dao.entity.ReservationEntity;
import org.myspringprogect.reservationslab.model.request.CreateReservationRequest;
import org.myspringprogect.reservationslab.model.response.GetReservationResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void saveReservation(CreateReservationRequest request);
    void updateReservationStatusToInactive(Long id);

    GetReservationResponse getReservationById(Long id);

    List<ReservationEntity> getActiveReservationsWithinDateRange(LocalDate startDate, LocalDate endDate) ;

}
