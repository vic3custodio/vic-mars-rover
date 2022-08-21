package com.vic.marsrover.util;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AtomicSequenceGenerator {

    private AtomicLong value = new AtomicLong(1);

    public long getNext() {
        return value.getAndIncrement();
    }
}