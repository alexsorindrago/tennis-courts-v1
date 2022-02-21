package com.tenniscourts.mocks;

import com.tenniscourts.guests.Guest;

public class GuestMocks {

    public static Guest getGuestMock() {
        Guest guestMock = Guest.builder().name("guest mock").build();
        return guestMock;
    }
}
