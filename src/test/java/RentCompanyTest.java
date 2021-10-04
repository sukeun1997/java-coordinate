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
        String s = "Sonata : 15리터\n" +
                "K5 : 20리터\n" +
                "Sonata : 12리터\n" +
                "Avante : 20리터\n" +
                "K5 : 30리터\n";
        assertThat(report).isEqualTo(s);
    }
}