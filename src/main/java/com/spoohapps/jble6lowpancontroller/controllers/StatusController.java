package com.spoohapps.jble6lowpancontroller.controllers;

import com.spoohapps.jble6lowpancontroller.model.Status;
import com.spoohapps.jble6lowpand.controller.Ble6LowpanController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.rmi.RemoteException;

@Path("/status")
public class StatusController {

    private final Ble6LowpanController ble6LowpanController;

    public StatusController(Ble6LowpanController ble6LowpanController) {
        this.ble6LowpanController = ble6LowpanController;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Status getConnectedDevices() throws RemoteException {
        Status currentStatus = new Status();
        currentStatus.setKnownDevices(ble6LowpanController.getKnownDevices());
        currentStatus.setAvailableDevices(ble6LowpanController.getAvailableDevices());
        currentStatus.setConnectedDevices(ble6LowpanController.getConnectedDevices());
        return currentStatus;
    }


}
