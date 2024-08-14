package uk.co.kleversom.screenmatch.model;

//import uk.co.kleversom.screenmatch.services.CheckChatGPT;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private int totalSeason;
    private Double rating;
    private String actors;
    private String plot;
    private String sinopse;
    private String poster;
    @Enumerated(EnumType.STRING)
    private Category genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalSeason() {
        return totalSeason;
    }

    public void setTotalSeason(int totalSeason) {
        this.totalSeason = totalSeason;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public Serie(DataSerie dataSerie){
        this.title = dataSerie.title();
        this.totalSeason = dataSerie.totalSeason();
        this.rating = OptionalDouble.of(Double.valueOf(dataSerie.rating())).orElse(0);
        this.genre = Category.fromString(dataSerie.genre().split(",")[0].trim());
        this.actors = dataSerie.actors();
        this.poster = dataSerie.poster();
        this.sinopse = dataSerie.sinopse().trim();
    }

    @Override
    public String toString() {
        return
                "genre=" + genre +
                ", title='" + title + '\'' +
                ", totalSeason=" + totalSeason +
                ", rating=" + rating +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
