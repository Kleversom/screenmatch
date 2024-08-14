package uk.co.kleversom.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer numberEpisode;
    private Double rate;
    private LocalDate dateRelease;

    public Episode(Integer numberSeason, DataEpisode dataEpisode) {
        this.season = numberSeason;
        this.title = dataEpisode.title();
        this.numberEpisode = dataEpisode.numberEpisode();
        try {
            this.rate = Double.valueOf(dataEpisode.rate());
        }catch (NumberFormatException ex){
            this.rate = 0.0;
        }

        try {
            this.dateRelease = LocalDate.parse(dataEpisode.dateRelease());
        } catch (DateTimeParseException ex){
            this.dateRelease = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public String toString() {
        return "season=" + season +
                ", title='" + title + '\'' +
                ", numberEpisode=" + numberEpisode +
                ", rate=" + rate +
                ", dateRelease=" + dateRelease;

    }
}
