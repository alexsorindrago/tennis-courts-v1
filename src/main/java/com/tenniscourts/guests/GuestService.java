package com.tenniscourts.guests;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public GuestDTO createGuest(CreateGuestRequestDTO createGuestRequestDTO) {
        Guest guest = Guest.builder().name(createGuestRequestDTO.getName()).build();
        return guestMapper.map(guestRepository.save(guest));
    }

}
