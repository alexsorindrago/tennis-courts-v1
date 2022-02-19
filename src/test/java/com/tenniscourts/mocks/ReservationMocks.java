package com.tenniscourts.mocks;

import com.tenniscourts.reservations.Reservation;
import com.tenniscourts.reservations.ReservationDTO;

import java.math.BigDecimal;

import static com.tenniscourts.mocks.GuestMocks.getGuestMock;
import static com.tenniscourts.mocks.ScheduleMocks.getScheduleMock;
import static com.tenniscourts.reservations.ReservationStatus.READY_TO_PLAY;

public class ReservationMocks {

    public static ReservationDTO getReservationDTOMock() {
        ReservationDTO reservationDTOMock = ReservationDTO.builder()
                .id(1L)
                .scheduledId(1L)
                .guestId(1L)
                .build();
        return reservationDTOMock;
    }

    public static Reservation getReservationMock() {
        Reservation reservationMock = Reservation.builder()
                .guest(getGuestMock())
                .schedule(getScheduleMock())
                .value(BigDecimal.TEN)
                .reservationStatus(READY_TO_PLAY)
                .build();
        return reservationMock;
    }
}
