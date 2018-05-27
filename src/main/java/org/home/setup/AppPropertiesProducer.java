package org.home.setup;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Dependent
public class AppPropertiesProducer {
    @Produces @ApplicationScoped @AppProperties
    public Properties properties() {
        Properties result = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("/app.properties")) {
            result.load(stream);
        } catch (IOException e) {
            log.error("Cannot load app.properties {}", e);
        }

        try (InputStream stream = loader.getResourceAsStream("/environment.properties")) {
            result.load(stream);
        } catch (IOException e) {
            log.error("Cannot load environment.properties {}", e);
        }

        return result;
    }
}
