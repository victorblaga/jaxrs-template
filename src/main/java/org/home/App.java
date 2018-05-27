package org.home;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class App extends ResourceConfig
{
    public App() {
        // configure jackson properties in the JacksonProvider class (i.e. how you want your objects to serialize)
        register(JacksonProvider.class);
        // this is a standard jersey class that enables jackson serialization / deserialization
        register(JacksonFeature.class);

        // register all your resources classes (i.e. the controllers)
        register(HomeResource.class);
        // register(MyOtherResource.class);
        // register (etc...)
    }
}
