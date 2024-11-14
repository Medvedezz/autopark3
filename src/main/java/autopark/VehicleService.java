package autopark;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicleService {
    private Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    public void addVehicle(Vehicle vehicle) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
            System.out.println("Vehicle added successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Vehicle getVehicle(int vehicleId) {
        Session session = getSession();
        try {
            return session.get(Vehicle.class, vehicleId);
        } finally {
            session.close();
        }
    }

    public void removeVehicle(int vehicleId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, vehicleId);
            if (vehicle != null) {
                session.delete(vehicle);
                System.out.println("Vehicle with ID " + vehicleId + " was removed successfully.");
            } else {
                System.out.println("Vehicle with ID " + vehicleId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(vehicle);
            transaction.commit();
            System.out.println("Vehicle with ID " + vehicle.getId() + " updated successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}