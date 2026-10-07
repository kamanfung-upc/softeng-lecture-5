import java.util.ArrayList;

public class Person {
    private String licenseNumber;
    private String name;
    private String surname;
    private String address;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Person(String licenseNumber, String name, String surname, String address) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    // Sum of the taxes of all the vehicles of this person
    public double getTotalTax() {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total = total + vehicle.calculateTax();
        }
        return total;
    }

    public void printInfo() {
        System.out.println(licenseNumber + " - " + name + " " + surname + " - " + address);
    }
}
