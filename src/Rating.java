import java.util.Arrays;
import java.util.List;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class Rating {

        private int userId;
        private int movieId;
        private double rating;



    //begint hier
    public Rating create(String str){
        List<String> lst = Arrays.asList(str.split(","));
        return create(lst);
    }

    public Rating create(List<String> data){
            return this.create(
                    Integer.parseInt(data.get(0)),
                    Integer.parseInt(data.get(1)),
                    Double.parseDouble(data.get(2))

            );
        }
    public Rating create(int userId, int movieId, double rating) {
            this.setUserId(userId);
            this.setMovieId(movieId);
            this.setRating(rating);

            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Rating{");
            sb.append("userId='").append(userId).append('\'');
            sb.append(", movieId=").append(movieId);
            sb.append(", rating=").append(rating);
            sb.append('}');
            return sb.toString();
        }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}


