package com.eszigeti.chatapp.service.util.impl;

import com.eszigeti.chatapp.service.util.TimeUtilService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeUtilServiceImpl implements TimeUtilService {

    @Override
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
