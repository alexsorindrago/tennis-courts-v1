package com.tenniscourts.schedules;

import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ScheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    TennisCourtRepository tennisCourtRepository;

    @Test
    void shouldAddSchedule() {
        // given
        TennisCourt tennisCourt = new TennisCourt();
        tennisCourt.setId(1L);
        tennisCourt.setName("court1");
        tennisCourtRepository.save(tennisCourt);

        // when
        scheduleService.addSchedule(
                tennisCourt.getId(),
                new CreateScheduleRequestDTO(tennisCourt.getId(), LocalDateTime.now().plusDays(1L)));

        // then
        assertThat(scheduleService.findSchedulesByTennisCourtId(tennisCourt.getId())).isNotNull();
    }

    @Test
    void findSchedulesByDates() {
        // given

        // when

        // then
    }
//
//    @Test
//    void findSchedule() {
//        // given
//
//        // when
//
//        // then
//    }
//
//    @Test
//    void findSchedulesByTennisCourtId() {
//        // given
//
//        // when
//
//        // then
//    }
}