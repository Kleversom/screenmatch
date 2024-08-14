package uk.co.kleversom.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title")String title,
                        @JsonAlias("totalSeasons") int totalSeason,
                        @JsonAlias("imdbRating") String rating,
                        @JsonAlias("Genre") String genre,
                        @JsonAlias("Actors") String actors,
                        @JsonAlias("Poster") String poster,
                        @JsonAlias("Plot") String sinopse) {
}
