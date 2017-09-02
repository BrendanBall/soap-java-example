package countries;

import countries.wsdl.Country;
import countries.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return args -> {
            String name = "Poland";

            if (args.length > 0) {
                name = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(name);
            Country country =response.getCountry();
            System.err.println(toString(country));
        };
    }

    public String toString(Country country) {
        return "Country { " +
                "name='" + country.getName() + '\'' +
                ", population=" + country.getPopulation() +
                ", capital='" + country.getCapital() + '\'' +
                ", currency=" + country.getCurrency() +
                " }";
    }
}