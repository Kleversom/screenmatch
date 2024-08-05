package uk.co.kleversom.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.co.kleversom.screenmatch.model.DataSerie;
import uk.co.kleversom.screenmatch.services.ConsumeAPI;
import uk.co.kleversom.screenmatch.services.DataConversion;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumeAPI = new ConsumeAPI();
		var json = consumeAPI.getData("http://www.omdbapi.com/?t=" + /*search.replace(" ", "+")*/"vikings" + "&apikey=987aeaf9");
		System.out.println(json);
		DataConversion conversion = new DataConversion();
		DataSerie data = conversion.getData(json, DataSerie.class);
		System.out.println(data);
	}
}
