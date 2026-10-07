public class Motorcycle extends Vehicle {
    private int engineDisplacement; // in cc

    public Motorcycle(String plate, String maker, String model, int engineDisplacement) {
        super(plate, maker, model);
        this.engineDisplacement = engineDisplacement;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public double calculateTax() {
        return engineDisplacement * 0.10;
    }

    @Override
    public void printInfo() {
        System.out.println(getPlate() + " - Motorcycle " + getMaker() + " " + getModel() + " (" + engineDisplacement + " cc)");
    }
}
