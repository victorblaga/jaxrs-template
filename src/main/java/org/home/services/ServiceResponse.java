package org.home.services;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Value
public class ServiceResponse {
    private String name;
    private String address;
    private LocalDateTime timestamp;
    private ZonedDateTime international;
}
