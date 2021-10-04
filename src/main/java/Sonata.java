public class Sonata extends Car {

    private final int Tripdistance;

    public Sonata(int Tripdistance) {
        this.Tripdistance = Tripdistance;
    }

    @Override
    double getDistancePerLiter() {
        return 10;
    }

    @Override
    double getTripDistance() {
        return this.Tripdistance;
    }

    @Override
    String getName() {
        return "Sonata";
    }
    @Override
    public String toString() {
        return getName() + " : " + (int) getChargeQuantity() + "리터\n";
    }
}
