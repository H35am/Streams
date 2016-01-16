import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class Main {

    public static void main(String[] args) {

        //Movies CSV lezer:
        BufferedReader movieBufferReader = getFileReader("movies.csv");
        ArrayList<Movie> movieCol = getMovieCollection(movieBufferReader);

        //Rating CSV lezer:
        BufferedReader ratingBufferReader = getFileReader("ratings.csv");
        ArrayList<Rating> ratingCol = getRatingCollection(ratingBufferReader);

        List<Movie> filterMovie = titleStartsWithLetter("m",movieCol);

    }

    public static List<Movie> titleStartsWithLetter(String start, ArrayList<Movie> lst){

        Stream<Movie> stream = lst.stream();

        stream.filter( item -> item.startsWith(start));

        return null;
    }


    private static ArrayList<Rating> getRatingCollection(BufferedReader br) {

        ArrayList<Rating> collection = new ArrayList();
        try {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                Rating rating = new Rating();
                rating.create(line);
                collection.add(rating);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static ArrayList<Movie> getMovieCollection(BufferedReader br) {

        ArrayList<Movie> collection = new ArrayList();
        try {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                Movie movie = new Movie();
                movie.create(line);
                collection.add(movie);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static BufferedReader getFileReader(String file) {
        try {
            return Files.newBufferedReader(Paths.get(file), StandardCharsets.ISO_8859_1);
        } catch (IOException ioe) {
            System.err.println("err: " + ioe);
        }
        return null;
    }

}
