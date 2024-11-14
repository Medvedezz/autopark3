package autopark;

import java.util.Scanner;

public class AppController {
    private VehicleService vehicleService;

    public AppController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Get Vehicle");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            handleUserChoice(choice);
        }
    }

    public void handleUserChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                // Add vehicle
                System.out.print("Enter make: ");
                String make = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                Vehicle newVehicle = new Vehicle(0, make, model, year);
                vehicleService.addVehicle(newVehicle);
                break;
            case 2:
                // Remove vehicle
                System.out.print("Enter vehicle ID to remove: ");
                int removeId = scanner.nextInt();
                vehicleService.removeVehicle(removeId);
                break;
            case 3:
                // Update vehicle
                System.out.print("Enter vehicle ID to update: ");
                int updateId = scanner.nextInt();
                System.out.print("Enter new make: ");
                String updateMake = scanner.next();
                System.out.print("Enter new model: ");
                String updateModel = scanner.next();
                System.out.print("Enter new year: ");
                int updateYear = scanner.nextInt();
                Vehicle updatedVehicle = new Vehicle(updateId, updateMake, updateModel, updateYear);
                vehicleService.updateVehicle(updatedVehicle);
                break;
            case 4:
                // Get vehicle
                System.out.print("Enter vehicle ID to get: ");
                int getId = scanner.nextInt();
                vehicleService.getVehicle(getId);
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, try again.");
        }
    }
}
