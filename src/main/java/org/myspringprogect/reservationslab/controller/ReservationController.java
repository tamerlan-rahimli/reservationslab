package org.myspringprogect.reservationslab.controller;

import lombok.RequiredArgsConstructor;
import org.myspringprogect.reservationslab.model.request.CreateReservationRequest;
import org.myspringprogect.reservationslab.model.response.GetReservationResponse;
import org.myspringprogect.reservationslab.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation(@RequestBody CreateReservationRequest request) {
        reservationService.saveReservation(request);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReservationStatusToInactive(@PathVariable Long id) {
        reservationService.updateReservationStatusToInactive(id);
    }

    @GetMapping("/{id}")
    public GetReservationResponse getReservation(@PathVariable Long id) {
      return   reservationService.getReservationById(id);
    }

}
