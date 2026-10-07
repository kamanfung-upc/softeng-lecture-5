public abstract class Vehicle {
    private String plate;
    private String maker;
    private String model;
    private Person owner;

    public Vehicle(String plate, String maker, String model) {
        this.plate = plate;
        this.maker = maker;
        this.model = model;
        this.owner = null;
    }

    public String getPlate() {
        return plate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public abstract double calculateTax();

    public void printInfo() {
        System.out.println(plate + " - " + maker + " " + model);
    }
}
