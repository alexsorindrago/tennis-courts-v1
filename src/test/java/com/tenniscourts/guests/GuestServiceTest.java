package com.tenniscourts.guests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GuestServiceTest {

    @Autowired
    GuestService guestService;

    @Test
    void createGuest() {
        // given
        CreateGuestRequestDTO createGuestRequestDTO = CreateGuestRequestDTO.builder()
                .name("guest")
                .build();

        // when
        GuestDTO result = guestService.createGuest(createGuestRequestDTO);

        // then
        assertNotNull(result);
    }
}