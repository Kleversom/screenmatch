package uk.co.kleversom.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title")String title,
                        @JsonAlias("totalSeasons") int totalSeason,
                        @JsonAlias("imdbRating") String rating) {
}
