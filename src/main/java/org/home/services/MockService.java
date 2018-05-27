package org.home.services;

import org.home.setup.AppProperties;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Properties;

@Dependent
@Alternative
public class MockService implements Service {
    @Inject @AppProperties
    private Properties properties;

    @Override
    public ServiceResponse hello() {
        return new ServiceResponse("i'm a mock", "mock", LocalDateTime.now(), ZonedDateTime.now());
    }
}
