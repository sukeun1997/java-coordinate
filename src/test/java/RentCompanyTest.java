import Fuel.Avante;
import Fuel.K5;
import Fuel.RentCompany;
import Fuel.Sonata;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() throws Exception {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        String s = "Fuel.Sonata : 15리터\n" +
                "Fuel.K5 : 20리터\n" +
                "Fuel.Sonata : 12리터\n" +
                "Fuel.Avante : 20리터\n" +
                "Fuel.K5 : 30리터\n";
        assertThat(report).isEqualTo(s);
    }
}