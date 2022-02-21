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
        TennisCourtDTO tennisCourtDTO = TennisCourtDTO.builder()
                .name("court1")
                .build();

        // when
        TennisCourtDTO result = tennisCourtService.addTennisCourt(tennisCourtDTO);

        // then
        assertNotNull(result);
    }

//    @Test
//    void findTennisCourtById() {
//        // given
//
//        // when
//
//        // then
//    }
//
//    @Test
//    void findTennisCourtWithSchedulesById() {
//        // given
//
//        // when
//
//        // then
//    }
}