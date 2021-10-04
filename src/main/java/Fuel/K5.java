package Fuel;

public class K5 extends Car {
    private final int Tripdistance;

    public K5(int Tripdistance) {
        this.Tripdistance = Tripdistance;
    }

    @Override
    double getDistancePerLiter() {
        return 13;
    }

    @Override
    double getTripDistance() {
        return this.Tripdistance;
    }

    @Override
    String getName() {
        return "Fuel.K5";
    }

    @Override
    public String toString() {
        return getName() + " : " + (int) getChargeQuantity() + "리터\n";
    }
}
