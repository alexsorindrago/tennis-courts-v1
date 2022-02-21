package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
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

    public Guest findById(Long guestId) {
        return guestRepository.findById(guestId).orElseThrow(()
                -> new EntityNotFoundException("guest not found"));
    }

    public GuestDTO findDtoById(Long guestId) {
        return guestMapper.map(guestRepository.findById(guestId).orElseThrow(()
                -> new EntityNotFoundException("guest not found")));
    }
}