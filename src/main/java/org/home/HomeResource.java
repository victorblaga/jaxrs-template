package org.home;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.home.services.Service;
import org.home.services.ServiceResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("home")
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestScoped
@NoArgsConstructor
@Slf4j
public class HomeResource {
    private Service service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public ServiceResponse hello() {
        log.info("Running hello endpoint.");
        return service.hello();
    }
}
