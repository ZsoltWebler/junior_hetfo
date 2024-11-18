package series;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class Series {

    private final Optional<LocalDate> releaseDate;
    private final String name;
    private final int season;
    private final int episode;
    private final int playTime;
    private final boolean watched;


    public Series(Optional<LocalDate> releaseDate, String name, int season, int episode, int playTime, boolean watched) {
        this.releaseDate = releaseDate;
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.playTime = playTime;
        this.watched = watched;
    }

    public Optional<LocalDate> getReleaseDate() {
        return releaseDate;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public int getPlayTime() {
        return playTime;
    }

    public boolean isWatched() {
        return watched;
    }

    @Override
    public String toString() {
        return "Series{" +
                "releaseDate=" + releaseDate +
                ", name='" + name + '\'' +
                ", season=" + season +
                ", episode=" + episode +
                ", playTime=" + playTime +
                ", watched=" + watched +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return season == series.season && episode == series.episode && playTime == series.playTime && watched == series.watched && Objects.equals(releaseDate, series.releaseDate) && Objects.equals(name, series.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(releaseDate, name, season, episode, playTime, watched);
    }
}
