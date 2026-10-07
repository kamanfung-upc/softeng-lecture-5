public class DieselCar extends Car {

    public DieselCar(String plate, String maker, String model, int co2Emissions) {
        super(plate, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.8;
    }

    @Override
    public void printInfo() {
        System.out.println(getPlate() + " - Diesel car " + getMaker() + " " + getModel() + " (" + getCo2Emissions() + " g CO2)");
    }
}
