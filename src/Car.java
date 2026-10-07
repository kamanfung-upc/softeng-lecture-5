public abstract class Car extends Vehicle {
    private int co2Emissions;

    public Car(String plate, String maker, String model, int co2Emissions) {
        super(plate, maker, model);
        this.co2Emissions = co2Emissions;
    }

    public int getCo2Emissions() {
        return co2Emissions;
    }

    public void setCo2Emissions(int co2Emissions) {
        this.co2Emissions = co2Emissions;
    }
}
