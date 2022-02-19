package com.tenniscourts.mocks;

import com.tenniscourts.tenniscourts.TennisCourt;

public class TennisCourtMocks {

    public static TennisCourt getTennisCourtMock() {
        TennisCourt tennisCourtMock = TennisCourt.builder().name("tennis court mock").build();
        return tennisCourtMock;
    }
}
