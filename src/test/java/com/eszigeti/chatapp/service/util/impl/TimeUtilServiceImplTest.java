package com.eszigeti.chatapp.service.util.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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