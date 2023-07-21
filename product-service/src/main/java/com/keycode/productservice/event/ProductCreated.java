package com.keycode.productservice.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class ProductCreated extends ApplicationEvent {
    public ProductCreated(Object source) {
        super(source);
    }

    public ProductCreated(Object source, Clock clock) {
        super(source, clock);
    }
}
