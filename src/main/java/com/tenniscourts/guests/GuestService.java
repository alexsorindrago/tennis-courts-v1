package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public GuestDTO findByName(String guestName) {
        return guestMapper.map(guestRepository.findByNameContaining(guestName));
    }

    public List<GuestDTO> findAllGuests() {
        return guestMapper.map(guestRepository.findAll());
    }

    public GuestDTO updateGuest(Long guestId, String newName) {
        Guest guest = findById(guestId);
        guest.setName(newName);
        return guestMapper.map(guestRepository.save(guest));
    }
}
