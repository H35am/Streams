import java.util.Arrays;
import java.util.List;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class Movie {

        private int movieId;
        private String title;
        private String genre;



        //begint hier
        public Movie create(String str){
            List<String> lst = Arrays.asList(str.split(","));
            return create(lst);
        }

        public Movie create(List<String> data){
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
            final StringBuilder sb = new StringBuilder("Rating{");
            sb.append("movieId='").append(movieId).append('\'');
            sb.append(", title=").append(title);
            sb.append(", genres=").append(genre);
            sb.append('}');
            return sb.toString();
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
}





