package com.spoohapps.jble6lowpancontroller;

import com.spoohapps.jble6lowpand.controller.Ble6LowpanController;
import com.spoohapps.jble6lowpand.model.BTAddress;

import java.rmi.RemoteException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class FakeBle6LowpanController implements Ble6LowpanController {

    private final CopyOnWriteArraySet<BTAddress> currentConnections = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<BTAddress> knownDevices = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<BTAddress> availableDevices = new CopyOnWriteArraySet<>();

    public FakeBle6LowpanController() {

        BTAddress connectedDevice = BTAddress.random();

        currentConnections.add(connectedDevice);

        knownDevices.add(connectedDevice);
        knownDevices.add(BTAddress.random());

        for (int i = 0; i < 3; i++) {
            availableDevices.add(BTAddress.random());
        }
    }

    @Override
    public Set<String> getAvailableDevices() {
        return availableDevices.stream()
                .map(BTAddress::toString)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getKnownDevices() {
        return knownDevices.stream()
                .map(BTAddress::toString)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getConnectedDevices() {
        return currentConnections.stream()
                .map(BTAddress::toString)
                .collect(Collectors.toSet());
    }

    @Override
    public void addKnownDevice(String s) throws RemoteException {
        knownDevices.add(new BTAddress(s));
    }

    @Override
    public void removeKnownDevice(String s) throws RemoteException {
        knownDevices.remove(new BTAddress(s));
    }
}
