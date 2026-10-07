import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaxSystem system = new TaxSystem();

        System.out.println("--- Add persons ---");
        system.addPerson(new Person("B-1001", "Sara", "Ahmad", "Carrer del Forn 1"));
        system.addPerson(new Person("B-1002", "Tsai-Hsuan", "Lee", "Carrer del Forn 2"));
        system.addPerson(new Person("B-1003", "Ka", "Fung", "Carrer del Forn 3"));
        system.addPerson(new Person("B-1004", "Justin", "Ho", "Carrer del Forn 4"));
        system.addPerson(new Person("B-1004", "Justin", "Repeated", "Carrer del Forn 4")); // error, same license

        System.out.println("\n--- Add vehicles (they start in the dealership, without owner) ---");
        system.addVehicle(new DieselCar("1111-AAA", "Renault", "Kangoo", 140));
        system.addVehicle(new PetrolCar("2222-BBB", "Seat", "Ibiza", 115));
        system.addVehicle(new Motorcycle("3333-CCC", "Honda", "PCX", 125));
        system.addVehicle(new HybridCar("4444-DDD", "Toyota", "Yaris", 90));
        system.addVehicle(new PetrolCar("5555-EEE", "Honda", "Civic", 100));

        System.out.println("\n--- Sell vehicles ---");
        double tax;
        tax = system.transferVehicle("1111-AAA", "B-1001");
        System.out.println("1111-AAA sold to B-1001, annual tax: " + tax + " euros");
        tax = system.transferVehicle("2222-BBB", "B-1003");
        System.out.println("2222-BBB sold to B-1003, annual tax: " + tax + " euros");
        tax = system.transferVehicle("3333-CCC", "B-1003");
        System.out.println("3333-CCC sold to B-1003, annual tax: " + tax + " euros");
        tax = system.transferVehicle("4444-DDD", "B-1004");
        System.out.println("4444-DDD sold to B-1004, annual tax: " + tax + " euros");
        System.out.println("5555-EEE is still in the dealership, owner: " + system.findVehicle("5555-EEE").getOwner());

        System.out.println("\n--- Edit a person and a vehicle ---");
        system.editPerson("B-1003", "Ka", "Fung", "Placa Major 7");
        system.editVehicle("2222-BBB", "Seat", "Ibiza FR");
        system.findPerson("B-1003").printInfo();
        system.findVehicle("2222-BBB").printInfo();

        System.out.println("\n--- Transfer the motorcycle from Ka to Justin ---");
        tax = system.transferVehicle("3333-CCC", "B-1004");
        System.out.println("3333-CCC transferred to B-1004, annual tax: " + tax + " euros");
        System.out.println("Vehicles of Ka:");
        for (Vehicle vehicle : system.findPerson("B-1003").getVehicles()) {
            vehicle.printInfo();
        }
        System.out.println("Vehicles of Justin:");
        for (Vehicle vehicle : system.findPerson("B-1004").getVehicles()) {
            vehicle.printInfo();
        }

        System.out.println("\n--- Tsai-Hsuan buys the car from the dealership ---");
        tax = system.transferVehicle("5555-EEE", "B-1002");
        System.out.println("5555-EEE sold to B-1002, annual tax: " + tax + " euros");

        System.out.println("\n--- Delete Sara (her car stays in the system without owner) ---");
        system.deletePerson("B-1001");
        System.out.println("Owner of 1111-AAA: " + system.findVehicle("1111-AAA").getOwner());

        System.out.println("\n--- Search ---");
        System.out.println("Persons with \"ka\":");
        ArrayList<Person> foundPersons = system.searchPersons("ka");
        for (Person person : foundPersons) {
            person.printInfo();
        }
        System.out.println("Vehicles with \"honda\":");
        ArrayList<Vehicle> foundVehicles = system.searchVehicles("honda");
        for (Vehicle vehicle : foundVehicles) {
            vehicle.printInfo();
        }

        System.out.println("\n--- Annual tax listing ---");
        system.printTaxListing();
    }
}
