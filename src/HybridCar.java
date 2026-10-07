public class HybridCar extends Car {

    public HybridCar(String plate, String maker, String model, int co2Emissions) {
        super(plate, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.2;
    }

    @Override
    public void printInfo() {
        System.out.println(getPlate() + " - Hybrid car " + getMaker() + " " + getModel() + " (" + getCo2Emissions() + " g CO2)");
    }
}
