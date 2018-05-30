package org.home.setup;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.home.JacksonProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Properties;

@ApplicationScoped
public class ClientProducer {
    @Produces
    @ApplicationScoped
    public Client client(@AppProperties Properties props) {
        return ClientBuilder.newBuilder()
                .withConfig(jacksonConfig())
                .build();
    }

    private ClientConfig jacksonConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonProvider.class);
        clientConfig.register(JacksonFeature.class);

        return clientConfig;
    }
}
