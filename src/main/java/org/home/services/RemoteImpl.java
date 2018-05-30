package org.home.services;

import org.home.setup.AppProperties;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

@Dependent
public class RemoteImpl implements Remote {
    private final Client client;
    private final Properties props;

    @Inject
    public RemoteImpl(Client client, @AppProperties Properties props) {
        this.client = client;
        this.props = props;
    }

    @Override
    public RemoteResponse call() {
        return client
                .target(props.getProperty("remote.uri"))
                .path(props.getProperty("remote.path"))
                .request(MediaType.APPLICATION_JSON)
                .get(RemoteResponse.class);
    }
}
