package org.myspringprogect.reservationslab.service;

import lombok.RequiredArgsConstructor;
import org.myspringprogect.reservationslab.dao.entity.ReservationEntity;
import org.myspringprogect.reservationslab.dao.repository.ReservationRepository;
import org.myspringprogect.reservationslab.model.enums.ReservationStatus;
import org.myspringprogect.reservationslab.model.request.CreateReservationRequest;
import org.myspringprogect.reservationslab.model.response.GetReservationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceHandler implements ReservationService{
    private final ReservationRepository reservationRepository;
    @Override
    public void saveReservation(CreateReservationRequest request) {
var res=reservationRepository.findByTableNameAndStatusNot(request.getTableName(),ReservationStatus.INACTIVE);

        if (res.isPresent()) {
            throw new RuntimeException("Rezarvasiya movcuddur!");
        }
       else{
        reservationRepository.save(ReservationEntity.builder().
                tableName(request.getTableName()).
                customer(request.getCustomer()).
                date(LocalDate.now()).
                status(ReservationStatus.ACTIVE).
                membersCount(request.getMembersCount())
                .build());}
    }

    @Override
    public void updateReservationStatusToInactive(Long id) {
        var reservation=getReservationIfExist(id);
        reservation.setStatus(ReservationStatus.INACTIVE);
        reservationRepository.save(reservation);
    }

    @Override
    public GetReservationResponse getReservationById(Long id) {
       var reservation= getReservationIfExist(id);
        return new GetReservationResponse(reservation.getTableName(),reservation.getCustomer(),reservation.getDate(),reservation.getStatus(),reservation.getMembersCount());
    }

    @Override
    public List<ReservationEntity> getActiveReservationsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByStatusAndReservationDateBetween(
                ReservationStatus.ACTIVE,
                startDate,
                endDate
        );
    }
    private ReservationEntity getReservationIfExist(Long id){
        return reservationRepository.findByIdAndStatusNot(id, ReservationStatus.INACTIVE).orElseThrow(RuntimeException::new);
    }




    }


