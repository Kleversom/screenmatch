package uk.co.kleversom.screenmatch.Main;

import uk.co.kleversom.screenmatch.model.DataEpisode;
import uk.co.kleversom.screenmatch.model.DataSeason;
import uk.co.kleversom.screenmatch.model.DataSerie;
import uk.co.kleversom.screenmatch.services.ConsumeAPI;
import uk.co.kleversom.screenmatch.services.DataConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner read = new Scanner(System.in);
    private final String WEBADRESS = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=987aeaf9";
    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private DataConversion conversion = new DataConversion();

    public void showMenu() {
        System.out.println("Type the serie's name: ");
        var serieName = read.nextLine();
        var json = consumeAPI.getData( WEBADRESS + serieName.replace(" ", "+") + API_KEY);
        DataSerie data = conversion.getData(json, DataSerie.class);
        System.out.println(data);

        List<DataSeason> season = new ArrayList<>();

        for (int i = 1; i<= data.totalSeason(); i++){
			json = consumeAPI.getData(WEBADRESS + serieName.replace(" ", "+") + "&season=" + i + API_KEY);
			DataSeason dataSeason = conversion.getData(json, DataSeason.class);
			season.add(dataSeason);
		}
		season.forEach(System.out::println);

//        for (int i = 0; i < data.totalSeason(); i++){
//            List<DataEpisode> episodeSeason = season.get(i).episodes();
//            for (int j = 0; j < episodeSeason.size(); j++){
//                System.out.println(episodeSeason.get(j).title());
//            }
//        }

        season.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

    }
}
