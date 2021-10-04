import java.util.ArrayList;
import java.util.List;

public class RentCompany{
    List<Car> carList;

    public RentCompany() {
        this.carList = new ArrayList<>();
    }
    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        String s = "";
        for (Car car : carList) {
            s += car.toString();
        }
        return s;
    }

    public void addCar(Car car) {
        carList.add(car);
    }
}
