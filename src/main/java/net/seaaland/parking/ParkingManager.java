package net.seaaland.parking;

import net.seaaland.parking.model.Credentials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    private final List<Credentials> credentialsList;

    public ParkingManager() {
        credentialsList = new ArrayList<>();
    }

    public void add(Credentials... credentials) {
        if (credentials == null) return;

        credentialsList.addAll(Arrays.asList(credentials));
    }

    public void remove(String plate) {
        credentialsList.removeIf(model -> model.getPlate().equals(plate));
    }

    public int getTotal() {
        return credentialsList.size();
    }

    public List<Credentials> getCredentialsList() {
        return credentialsList;
    }
}
