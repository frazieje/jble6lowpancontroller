package com.spoohapps.jble6lowpancontroller;

import com.spoohapps.jble6lowpancontroller.controllers.StatusController;

import com.spoohapps.jble6lowpand.controller.Ble6LowpanController;
import com.spoohapps.jble6lowpand.controller.Ble6LowpanControllerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashSet;
import java.util.Set;

import static com.spoohapps.jble6lowpand.controller.RemoteBle6LowpanControllerService.ControllerName;

@ApplicationPath("/api")
public class Ble6lowpanControllerService extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    private Ble6LowpanController ble6lowpanController;

    private static final Logger logger = LoggerFactory.getLogger(Ble6LowpanControllerService.class);

    public Ble6lowpanControllerService() {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            ble6lowpanController = (Ble6LowpanController) registry.lookup(ControllerName);
        } catch (RemoteException | NotBoundException re) {
//            logger.error("jble6lowpand not found via rmi defaulting to no-op controller");
//            ble6lowpanController = new NoopBle6LowpanController();
            logger.info("using a fake ble6lowpan controller");
            ble6lowpanController = new FakeBle6LowpanController();
        }
        singletons.add(new StatusController(ble6lowpanController));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
