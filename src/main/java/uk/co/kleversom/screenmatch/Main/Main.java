package uk.co.kleversom.screenmatch.Main;

import uk.co.kleversom.screenmatch.model.DataEpisode;
import uk.co.kleversom.screenmatch.model.DataSeason;
import uk.co.kleversom.screenmatch.model.DataSerie;
import uk.co.kleversom.screenmatch.services.ConsumeAPI;
import uk.co.kleversom.screenmatch.services.DataConversion;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner read = new Scanner(System.in);
    private final String WEBADRESS = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=987aeaf9";
    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private DataConversion conversion = new DataConversion();
    private List<DataSerie> dataSeries = new ArrayList<>();

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar series buscadas
                                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listSeriesSearched();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }



    private void buscarSerieWeb() {
        DataSerie data = getDataSerie();
        dataSeries.add(data);
        System.out.println(data);    }

    private DataSerie getDataSerie() {
        System.out.println("Digite o nome da série para busca");
        var nameSerie = read.nextLine();
        var json = consumeAPI.getData(WEBADRESS + nameSerie.replace(" ", "+") + API_KEY);
        DataSerie data = conversion.getData(json, DataSerie.class);
        return data;
    }

    private void buscarEpisodioPorSerie(){
        DataSerie dataSerie = getDataSerie();
        List<DataSeason> season = new ArrayList<>();

        for (int i = 1; i <= dataSerie.totalSeason(); i++) {
            var json = consumeAPI.getData(WEBADRESS + dataSerie.title().replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dataSeason = conversion.getData(json, DataSeason.class);
            season.add(dataSeason);
        }
        season.forEach(System.out::println);
    }
    private void listSeriesSearched() {
        dataSeries.forEach(System.out::println);
    }
}
