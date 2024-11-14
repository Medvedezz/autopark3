package autopark;

public class Main {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();

        // Додавання нового транспортного засобу
        Vehicle newVehicle = new Vehicle("Toyota", "Corolla", 2022);
        vehicleService.addVehicle(newVehicle);

        // Отримання транспортного засобу за ID
        Vehicle foundVehicle = vehicleService.getVehicle(1); // Змініть ID за потребою
        if (foundVehicle != null) {
            System.out.println("Found vehicle: " + foundVehicle);
        }

        // Видалення транспортного засобу
        vehicleService.removeVehicle(1); // Змініть ID за потребою
    }
}