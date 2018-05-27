package org.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.ws.rs.ext.ContextResolver;

public class JacksonProvider implements ContextResolver<ObjectMapper> {
    private ObjectMapper objectMapper;

    public JacksonProvider() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // JacksonModule that knows how to work with LocalDateTime / ZonedDateTime objects
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return objectMapper;
    }
}
