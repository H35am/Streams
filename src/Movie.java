import java.util.Arrays;
import java.util.List;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class Movie {


    private int movieId;
    private String title;
    private String genre;
    private List<Rating> ratings;


    //begint hier
    public Movie create(String str) {
        List<String> lst = Arrays.asList(str.split(","));
        return create(lst);
    }

    public Movie create(List<String> data) {
        return this.create(
                Integer.parseInt(data.get(0)),
                data.get(1),
                data.get(2)

        );
    }

    public Movie create(int movieId, String title, String genre) {
        this.setMovieId(movieId);
        this.setTitle(title);
        this.setGenre(genre);

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("movieId='").append(movieId).append('\'');
        sb.append(", title=").append(title);
        sb.append(", genres=").append(genre);
        for (Rating r : ratings)
            sb.append(", rating=").append(r);
        sb.append('}');
        return sb.toString();
    }

    public boolean titleStartsWithLetter(String start) {
        return title.startsWith(start);
    }

    public boolean hasGenre(String genre) {
        return this.genre.equals(genre);
    }

    public boolean hasGenres(List<String> genres) {

        boolean ok = true;

        for (String temp : genres) {
            if (!this.genre.contains(temp)) {
                ok = false;
            }

        }
        return ok;

    }

    public boolean hasMinimumRating(Float rating) {
        for (Rating r : ratings){
            if(r.getRating() >= rating){
                return true;
            }
        }
        return false;
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}





