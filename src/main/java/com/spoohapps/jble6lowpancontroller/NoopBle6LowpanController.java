package com.spoohapps.jble6lowpancontroller;

import com.spoohapps.jble6lowpand.controller.Ble6LowpanController;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

public class NoopBle6LowpanController implements Ble6LowpanController {
    @Override
    public Set<String> getConnectedDevices() throws RemoteException {
        return new HashSet<>();
    }

    @Override
    public Set<String> getAvailableDevices() throws RemoteException {
        return new HashSet<>();
    }

    @Override
    public Set<String> getKnownDevices() throws RemoteException {
        return new HashSet<>();
    }

    @Override
    public void addKnownDevice(String s) throws RemoteException {

    }

    @Override
    public void removeKnownDevice(String s) throws RemoteException {

    }
}
