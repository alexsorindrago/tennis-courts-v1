package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/guest")
public class GuestController extends BaseRestController {

    private final GuestService guestService;

    @PostMapping
    public ResponseEntity<GuestDTO> createGuest(@RequestBody CreateGuestRequestDTO createGuestRequestDTO) {
        return ResponseEntity.created(locationByEntity(guestService.createGuest(createGuestRequestDTO).getId())).build();
    }

    @GetMapping("/{guestId}")
    public ResponseEntity<GuestDTO> findById(@RequestParam Long guestId) {
        return ResponseEntity.ok(guestService.findDtoById(guestId));
    }

    @GetMapping("/{guestName}")
    public ResponseEntity<GuestDTO> findByName(@RequestParam String guestName) {
        return ResponseEntity.ok(guestService.findByName(guestName));
    }

    @GetMapping("allGuests")
    public ResponseEntity<List<GuestDTO>> findAllGuests() {
        return ResponseEntity.ok(guestService.findAllGuests());
    }

    @PutMapping
    public ResponseEntity<GuestDTO> updateGuest(@RequestParam("guestId") Long guestId, @RequestParam("name") String name) {
        return ResponseEntity.ok(guestService.updateGuest(guestId, name));
    }

    @DeleteMapping("{guestId}")
    public ResponseEntity<Void> deleteGuest(@RequestParam("guestId") Long guestId) {
        guestService.deleteGuest(guestId);
        return ResponseEntity.created(locationByEntity(guestId)).build();
    }


}
