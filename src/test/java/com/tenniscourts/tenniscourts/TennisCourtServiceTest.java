package com.tenniscourts.tenniscourts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TennisCourtServiceTest {

    @Autowired
    TennisCourtService tennisCourtService;

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

    private TennisCourtDTO setup() {
        TennisCourtDTO tennisCourtDTO = TennisCourtDTO.builder()
                .id(1L)
                .name("court1")
                .build();
        return tennisCourtDTO;
    }

//    @Test
//    void findTennisCourtWithSchedulesById() {
//        // given
//
//        // when
//
//        // then
//    }
}