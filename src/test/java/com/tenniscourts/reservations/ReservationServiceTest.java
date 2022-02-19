package com.tenniscourts.reservations;

import com.tenniscourts.schedules.Schedule;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.tenniscourts.mocks.ReservationMocks.getReservationDTOMock;
import static com.tenniscourts.mocks.ReservationMocks.getReservationMock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ReservationService.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;

    @Mock
    ReservationRepository reservationRepository;

    @Mock
    ReservationMapper reservationMapper;

    @Test
    public void getRefundValueFullRefund() {
        Schedule schedule = new Schedule();

        LocalDateTime startDateTime = LocalDateTime.now().plusDays(2);

        schedule.setStartDateTime(startDateTime);

        Assert.assertEquals(reservationService.getRefundValue(Reservation.builder().schedule(schedule).value(new BigDecimal(10L)).build()), new BigDecimal(10));
    }

    @Test
    public void shouldRescheduleReservation() {
        // given
        Reservation reservationMock = getReservationMock();
        ReservationDTO reservationDTOMock = getReservationDTOMock();

        when(reservationRepository.findById(1L)).thenReturn(Optional.ofNullable(reservationMock));
        when(reservationMapper.map(any(CreateReservationRequestDTO.class))).thenReturn(reservationMock);
        when(reservationMapper.map(reservationMock)).thenReturn(reservationDTOMock);
        when(reservationRepository.save(reservationMock)).thenReturn(reservationMock);

        // when
        ReservationDTO result = reservationService.rescheduleReservation(1L, 2L);

        // then
        assertThat(result).isNotNull();

    }
}