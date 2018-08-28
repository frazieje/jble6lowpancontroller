package com.spoohapps.jble6lowpancontroller;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Ble6lowpanControllerService extends Application {

    private final HttpServer httpServer;

    private static final Logger logger = LoggerFactory.getLogger(Ble6lowpanControllerService.class);

    private static final int defaultPort = 8080;
    private static final String defaultPath = "/opt/jble6lowpancontroller/web/";

    public Ble6lowpanControllerService(int port, String path) {

        URI baseUri = UriBuilder.fromPath("/").host("0.0.0.0").port(port).build();

        httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri);

        StaticHttpHandler handler = new StaticHttpHandler(path);
        httpServer.getServerConfiguration().addHttpHandler(handler);
    }

    private void start() {
        logger.info("Starting HTTP Server...");
        try {
            httpServer.start();
            logger.info("HTTP Server Started...");
        } catch (IOException e) {
            logger.error("Error starting HTTP Server", e);
        }
    }

    private void stop() {
        logger.info("Stopping HTTP Server...");
        httpServer.shutdownNow();
        logger.info("HTTP Server Stopped.");
    }


    public static void main(String[] args) {

        int port = defaultPort;

        String path = defaultPath;

        for (int i = 0; i < args.length; i++) {
            if (args[i].matches("^-[cCpP]$")) {
                String arg = args[i].replaceAll("-", "").toLowerCase();
                if (arg.equals("c")) {
                    path = args[i+1];
                    i++;
                } else if (arg.equals("p")) {
                    try {
                        port = Integer.parseInt(args[i+1]);
                        i++;
                    } catch (NumberFormatException nfe) {
                        logger.error(nfe.getMessage());
                    }
                }
            }
        }

        logger.info("HTTP Server Port: {}", port);
        logger.info("Static File Location: {}", path);

        Ble6lowpanControllerService service = new Ble6lowpanControllerService(port, path);

        service.start();

        Runtime.getRuntime().addShutdownHook(new Thread(service::stop));

    }
}
