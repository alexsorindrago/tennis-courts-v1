package com.tenniscourts.mocks;

import com.tenniscourts.schedules.Schedule;

import java.time.LocalDateTime;

import static com.tenniscourts.mocks.TennisCourtMocks.getTennisCourtMock;

public class ScheduleMocks {
    public static Schedule getScheduleMock() {
        Schedule scheduleMock = Schedule.builder()
                .tennisCourt(getTennisCourtMock())
                .startDateTime(LocalDateTime.now().plusDays(1))
                .endDateTime(LocalDateTime.now().plusDays(2))
                .build();
        return scheduleMock;
    }
}
