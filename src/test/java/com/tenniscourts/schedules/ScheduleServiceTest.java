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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ScheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    TennisCourtRepository tennisCourtRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

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
    void shouldFindSchedulesByDates() {
        // given
        setup();

        // when
        List<ScheduleDTO> result = scheduleService.findSchedulesByDates(LocalDateTime.now(), LocalDateTime.now().plusDays(4));

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void shouldFindSchedule() {
        // given
        Schedule schedule = setup();

        // when
        ScheduleDTO result = scheduleService.findSchedule(schedule.getId());

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void findSchedulesByTennisCourtId() {
        // given
        setup();

        // when
        List<ScheduleDTO> result = scheduleService.findSchedulesByTennisCourtId(setup().getTennisCourt().getId());

        // then
        assertThat(result).isNotNull();
    }

    private Schedule setup() {
        TennisCourt tennisCourt = new TennisCourt();
        tennisCourt.setId(1L);
        tennisCourt.setName("court1");
        tennisCourtRepository.save(tennisCourt);
        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setTennisCourt(tennisCourt);
        schedule.setStartDateTime(LocalDateTime.now().plusDays(1));
        schedule.setEndDateTime(LocalDateTime.now().plusDays(1).plusHours(1));
        scheduleRepository.save(schedule);
        return schedule;
    }
}