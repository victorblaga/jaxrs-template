package org.home.services;

import lombok.extern.slf4j.Slf4j;
import org.home.setup.AppProperties;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;

@Dependent
@Slf4j
public class ServiceImpl implements Service {
    private final Properties properties;

    @Inject
    public ServiceImpl(@AppProperties Properties properties) {
        this.properties = properties;
    }

    @Override
    public ServiceResponse hello() {
        log.info("Reading properties: {}", properties.getProperty("environment"));
        return new ServiceResponse("hello", "world", LocalDateTime.now(), ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Berlin")));
    }
}
