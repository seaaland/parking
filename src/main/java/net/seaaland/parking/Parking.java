package net.seaaland.parking;

import net.seaaland.parking.model.Credentials;
import net.seaaland.parking.model.type.ModelType;

import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingManager manager = new ParkingManager();

        System.out.println("-> Select the option you want to use:");
        System.out.println(" [1] View a specific vehicle;\n [2] View all vehicles.");

        Credentials m1 = new Credentials(ModelType.MOTORCICLE, "Mauricio", "LWD-8262", true);
        Credentials c1 = new Credentials(ModelType.CAR, "Gabriel", "NEV-5646", true);
        Credentials m2 = new Credentials(ModelType.MOTORCICLE, "Gabriela", "NEW-5483", true);
        Credentials c2 = new Credentials(ModelType.CAR, "Marcia", "NBP-1990", true);
        Credentials c3 = new Credentials(ModelType.CAR, "Lorena", "IAI-9678", true);

        manager.add(m1, m2, c1, c2, c3);

        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("-> Insert the license plate:");
                String plate = scanner.next();

                for (int i = 0; i < 10; i++)
                    System.out.println();

                if (manager.getCredentialsList().stream().noneMatch(model -> model.getPlate().equals(plate))) {
                    System.out.println("-> The entered car is not currently parked.");
                    break;
                }

                Credentials credentials = manager.getCredentialsList().stream().filter(model -> model.getPlate().equals(plate)).findFirst().get();

                System.out.println("[1] Type: " + credentials.getType() + ", Owner: " + credentials.getOwner() + ", Plate: " + credentials.getPlate());
                break;
            }

            case 2: {
                for (int i = 0; i < 10; i++)
                    System.out.println();

                int i = 1;
                for (Credentials credentials : manager.getCredentialsList()) {
                    System.out.println("[" + i + "] Type: " + credentials.getType().name() + ", Owner: " + credentials.getOwner() + ", Plate: " + credentials.getPlate());

                    i += 1;
                }

                System.out.println("\n -> There are a total of " + manager.getTotal() + " vehicles.");
            }
        }
    }
}