package com.EniacDevelopment.Configuration_Application.Connection;

import com.EniacDevelopment.Configuration_Application.Application;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by nickd on 01/04/2017.
 */
public class Connection {
    public static final String BASE_URI = "http://localhost:9090/service/"; /*Default localhost URL*/

    private static WebTarget REST_connection; /*Static REST connection object*/
    private static String ip_address, port_number, connection_url;

    static{

    }

    public static WebTarget getWebTarger() {
        // create the client
        Client c = ClientBuilder.newClient()
                .register(SseFeature.class)
                .register(JacksonJsonProvider.class);

        return c.target(BASE_URI);
    }
}

