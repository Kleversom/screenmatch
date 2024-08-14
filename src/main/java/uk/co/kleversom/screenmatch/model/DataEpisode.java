package uk.co.kleversom.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public record DataEpisode(@JsonAlias ("Title") String title,
                          @JsonAlias ("Episode") Integer numberEpisode,
                          @JsonAlias ("imdbRating") String rate,
                          @JsonAlias ("Released") String dateRelease) {

}
