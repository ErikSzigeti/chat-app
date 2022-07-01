package com.eszigeti.actionmonitor.service.util.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TimeUtilServiceImplTest {

    private TimeUtilServiceImpl underTest;

    @BeforeEach
    private void setUp() {
        underTest = new TimeUtilServiceImpl();
    }

    @Test
    public void getCurrentTimeShouldReturnValidTimeWhenCalled() {
        //WHEN
        LocalDateTime actual = underTest.getCurrentTime();
        //THEN
        Assertions.assertNotNull(actual);
    }

}