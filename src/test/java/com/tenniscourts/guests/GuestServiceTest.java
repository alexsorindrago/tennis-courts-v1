package com.tenniscourts.guests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GuestServiceTest {

    @Autowired
    GuestService guestService;

    @Autowired
    GuestMapper guestMapper;

    @Test
    void shouldCreateGuest() {
        // given
        CreateGuestRequestDTO createGuestRequestDTO = CreateGuestRequestDTO.builder()
                .name("guest")
                .build();

        // when
        GuestDTO result = guestService.createGuest(createGuestRequestDTO);

        // then
        assertNotNull(result);
    }

    @Test
    void shouldFindById() {
        // given
        CreateGuestRequestDTO createGuestRequestDTO = CreateGuestRequestDTO.builder()
                .name("guest")
                .build();
        GuestDTO guestDTO = guestService.createGuest(createGuestRequestDTO);

        // when
        Guest result = guestService.findById(guestMapper.map(guestDTO).getId());

        // then
        assertNotNull(result);
    }

    @Test
    void shouldFindByName() {
        // given
        CreateGuestRequestDTO createGuestRequestDTO = CreateGuestRequestDTO.builder()
                .name("guest")
                .build();
        GuestDTO guestDTO = guestService.createGuest(createGuestRequestDTO);

        // when
        GuestDTO result = guestService.findByName(guestMapper.map(guestDTO).getName());

        // then
        assertNotNull(result);
    }

    @Test
    void shouldFindAll() {
        //given Rafael Nadal and Roger Federer aleady in DB

        //when
        List<GuestDTO> result = guestService.findAllGuests();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}