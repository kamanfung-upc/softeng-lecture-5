import java.util.ArrayList;

public class TaxSystem {
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Persons
    public Person findPerson(String licenseNumber) {
        for (Person person : persons) {
            if (person.getLicenseNumber().equals(licenseNumber)) {
                return person;
            }
        }
        return null;
    }

    public void addPerson(Person person) {
        if (findPerson(person.getLicenseNumber()) != null) {
            System.out.println("Error: there is already a person with license " + person.getLicenseNumber());
            return;
        }
        persons.add(person);
    }

    public void editPerson(String licenseNumber, String name, String surname, String address) {
        Person person = findPerson(licenseNumber);
        if (person == null) {
            System.out.println("Error: person " + licenseNumber + " not found");
            return;
        }
        person.setName(name);
        person.setSurname(surname);
        person.setAddress(address);
    }

    public void deletePerson(String licenseNumber) {
        Person person = findPerson(licenseNumber);
        if (person == null) {
            System.out.println("Error: person " + licenseNumber + " not found");
            return;
        }
        // The vehicles of the person stay in the system without owner
        for (Vehicle vehicle : person.getVehicles()) {
            vehicle.setOwner(null);
        }
        persons.remove(person);
    }

    public ArrayList<Person> searchPersons(String text) {
        ArrayList<Person> result = new ArrayList<>();
        text = text.toLowerCase();
        for (Person person : persons) {
            if (person.getLicenseNumber().toLowerCase().contains(text)
                    || person.getName().toLowerCase().contains(text)
                    || person.getSurname().toLowerCase().contains(text)) {
                result.add(person);
            }
        }
        return result;
    }

    // Vehicles

    public Vehicle findVehicle(String plate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        if (findVehicle(vehicle.getPlate()) != null) {
            System.out.println("Error: there is already a vehicle with plate " + vehicle.getPlate());
            return;
        }
        vehicles.add(vehicle);
    }

    public void editVehicle(String plate, String maker, String model) {
        Vehicle vehicle = findVehicle(plate);
        if (vehicle == null) {
            System.out.println("Error: vehicle " + plate + " not found");
            return;
        }
        vehicle.setMaker(maker);
        vehicle.setModel(model);
    }

    public void deleteVehicle(String plate) {
        Vehicle vehicle = findVehicle(plate);
        if (vehicle == null) {
            System.out.println("Error: vehicle " + plate + " not found");
            return;
        }
        if (vehicle.getOwner() != null) {
            vehicle.getOwner().removeVehicle(vehicle);
        }
        vehicles.remove(vehicle);
    }

    public ArrayList<Vehicle> searchVehicles(String text) {
        ArrayList<Vehicle> result = new ArrayList<>();
        text = text.toLowerCase();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().toLowerCase().contains(text)
                    || vehicle.getMaker().toLowerCase().contains(text)
                    || vehicle.getModel().toLowerCase().contains(text)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Sale / transfer
    public double transferVehicle(String plate, String buyerLicense) {
        Vehicle vehicle = findVehicle(plate);
        Person buyer = findPerson(buyerLicense);
        if (vehicle == null || buyer == null) {
            System.out.println("Error: cannot transfer " + plate + " to " + buyerLicense);
            return 0;
        }
        Person seller = vehicle.getOwner();
        if (seller != null) {
            seller.removeVehicle(vehicle);
        }
        buyer.addVehicle(vehicle);
        vehicle.setOwner(buyer);
        return vehicle.calculateTax();
    }

    //  Annual listing
    public void printTaxListing() {
        for (Person person : persons) {
            person.printInfo();
            for (Vehicle vehicle : person.getVehicles()) {
                System.out.print("    ");
                vehicle.printInfo();
                System.out.println("        tax: " + vehicle.calculateTax() + " euros");
            }
            System.out.println("    TOTAL: " + person.getTotalTax() + " euros");
        }
    }
}
