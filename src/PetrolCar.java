public class PetrolCar extends Car {

    public PetrolCar(String plate, String maker, String model, int co2Emissions) {
        super(plate, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.4;
    }

    @Override
    public void printInfo() {
        System.out.println(getPlate() + " - Petrol car " + getMaker() + " " + getModel() + " (" + getCo2Emissions() + " g CO2)");
    }
}
