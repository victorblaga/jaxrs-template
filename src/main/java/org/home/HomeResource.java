package org.home;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.home.services.Remote;
import org.home.services.RemoteResponse;
import org.home.services.Service;
import org.home.services.ServiceResponse;
import org.home.setup.AppProperties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

@Path("home")
@RequestScoped
@AllArgsConstructor(onConstructor = @__(@Inject))
@NoArgsConstructor
@Slf4j
public class HomeResource {
    private Service service;
    private Remote remote;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public ServiceResponse hello() {
        log.info("Running hello endpoint.");
        return service.hello();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remote")
    public RemoteResponse remote() {
        log.info("Running remote endpoint.");
        return remote.call();
    }
}
