package com.spoohapps.jble6lowpancontroller.model;

import java.util.Set;

public class Status {

    private Set<String> connectedDevices;
    private Set<String> knownDevices;
    private Set<String> availableDevices;

    public Set<String> getConnectedDevices() {
        return connectedDevices;
    }

    public void setConnectedDevices(Set<String> connectedDevices) {
        this.connectedDevices = connectedDevices;
    }

    public Set<String> getKnownDevices() {
        return knownDevices;
    }

    public void setKnownDevices(Set<String> knownDevices) {
        this.knownDevices = knownDevices;
    }

    public Set<String> getAvailableDevices() {
        return availableDevices;
    }

    public void setAvailableDevices(Set<String> availableDevices) {
        this.availableDevices = availableDevices;
    }

}
