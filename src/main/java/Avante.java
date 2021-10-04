public class Avante extends Car{
    private final int Tripdistance;

    public Avante(int Tripdistance) {
        this.Tripdistance = Tripdistance;
    }

    @Override
    double getDistancePerLiter() {
        return 15;
    }

    @Override
    double getTripDistance() {
        return this.Tripdistance;
    }

    @Override
    String getName() {
        return "Avante";
    }
    @Override
    public String toString() {
        return getName() + " : " + (int) getChargeQuantity() + "리터\n";
    }
}
