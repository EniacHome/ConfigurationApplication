package com.EniacDevelopment.Configuration_Application.util.Connection;

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

    private enum connection_status{
        CONNECTED, DISCONNECTED
    }

    private Connection(){}

    private WebTarget getWebTarger() {
        // create the client
        Client c = ClientBuilder.newClient()
                .register(SseFeature.class)
                .register(JacksonJsonProvider.class);

        return c.target(BASE_URI);
    }

    public void configure_connection(String ip_address, String port_number){
        connection_url = "http://" + ip_address + ":" + port_number + "/service";
    }

    public void test_connection(){

    }



}

