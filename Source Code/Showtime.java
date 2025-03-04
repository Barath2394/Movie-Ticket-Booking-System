import java.util.*;

public class Showtime implements Comparable<Showtime> {
    private String movieName;
    private String time;

    public Showtime(String movieName, String time) {
        this.movieName = movieName;
        this.time = time;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTime() {
        return time;
    }

    // Compare showtimes by time
    @Override
    public int compareTo(Showtime other) {
        return this.time.compareTo(other.time);
    }

    @Override
    public String toString() {
        return "Movie: " + movieName + " | Showtime: " + time;
    }
}

