package com.tenniscourts.tenniscourts;

import com.tenniscourts.schedules.Schedule;
import com.tenniscourts.schedules.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TennisCourtServiceTest {

    @Autowired
    TennisCourtService tennisCourtService;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    TennisCourtMapper tennisCourtMapper;

    @Test
    void shouldAddTennisCourt() {
        // given
        setup();

        // when
        TennisCourtDTO result = tennisCourtService.addTennisCourt(setup());

        // then
        assertNotNull(result);
    }

    @Test
    void findTennisCourtById() {
        // given
        setup();

        // when
        TennisCourtDTO result = tennisCourtService.findTennisCourtById(setup().getId());

        // then
        assertNotNull(result);
    }

    @Test
    void findTennisCourtWithSchedulesById() {
        // given
        setup();

        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setTennisCourt(tennisCourtMapper.map(setup()));
        schedule.setStartDateTime(LocalDateTime.now().plusDays(1));
        schedule.setEndDateTime(LocalDateTime.now().plusDays(1).plusHours(1));
        scheduleRepository.save(schedule);
        // when
        TennisCourtDTO result = tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtMapper.map(setup()).getId());

        // then
        assertNotNull(result);
    }

    private TennisCourtDTO setup() {
        TennisCourtDTO tennisCourtDTO = TennisCourtDTO.builder()
                .id(1L)
                .name("court1")
                .build();
        return tennisCourtDTO;
    }
}