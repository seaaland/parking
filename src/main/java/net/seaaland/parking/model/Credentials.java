package net.seaaland.parking.model;

import net.seaaland.parking.model.type.ModelType;

public class Credentials {
    private final ModelType type;
    private final String owner, plate;

    private final boolean paid;

    public Credentials(ModelType type, String owner, String plate, boolean paid) {
        this.type = type;
        this.owner = owner;
        this.plate = plate;
        this.paid = paid;
    }

    public ModelType getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    public String getPlate() {
        return plate;
    }

    public boolean isPaid() {
        return paid;
    }
}
