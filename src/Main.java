import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class Main {

    public static void main(String[] args) {
        //Rating CSV lezer:
        BufferedReader ratingBufferReader = getFileReader("data/ratings.csv");
        ArrayList<Rating> ratingCol = getRatingCollection(ratingBufferReader);

        //Movies CSV lezer:
        BufferedReader movieBufferReader = getFileReader("data/movies.csv");
        ArrayList<Movie> movieCol = getMovieCollection(movieBufferReader, ratingCol);

        List<Movie> filterByRating = hasMinimumRating(4.0f, movieCol);

        for (Movie movie : filterByRating)
            System.out.println(movie.toString());


        List<Movie> filteredByGenres = hasGenres(Arrays.asList("Comedy", "Action", "Drama", "Romance"), movieCol);

        for (Movie movie : filteredByGenres)
            System.out.println(movie.toString());


        List<Movie> filteredByGenre = hasGenre("Comedy", movieCol);

        for (Movie movie : filteredByGenre)
            System.out.println(movie.toString());


        List<Movie> filterMovie = titleStartsWithLetter("M", movieCol);

        for (Movie movie : filterMovie)
            System.out.println(movie.toString());


    }


    //http://zeroturnaround.com/rebellabs/java-8-explained-applying-lambdas-to-java-collections/
    //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    //http://www.dreamsyssoft.com/java-8-lambda-tutorial/filter-tutorial.php


    //Titel algoritme
    public static List<Movie> titleStartsWithLetter(String start, ArrayList<Movie> lst) {

        Stream<Movie> stream = lst.stream();
        return stream.filter(item -> item.titleStartsWithLetter(start)).collect(Collectors.toList());

    }

    //Genre algoritme
    public static List<Movie> hasGenre(String genre, ArrayList<Movie> lst) {

        Stream<Movie> stream = lst.stream();
        return stream.filter(item -> item.hasGenre(genre)).collect(Collectors.toList());

    }

    //Heeft genres algoritme
    public static List<Movie> hasGenres(List<String> genres, ArrayList<Movie> lst) {

        Stream<Movie> stream = lst.stream();
        return stream.filter(item -> item.hasGenres(genres)).collect(Collectors.toList());

    }

    public static List<Movie> hasMinimumRating(Float rating, ArrayList<Movie> lst){

        Stream<Movie> stream = lst.stream();
        return stream.filter(item -> item.hasMinimumRating(rating)).collect(Collectors.toList());

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

    private static ArrayList<Movie> getMovieCollection(BufferedReader br, ArrayList<Rating> ratings) {

        ArrayList<Movie> collection = new ArrayList();

        try {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                Movie movie = new Movie();
                movie.create(line);
                ArrayList<Rating> ratingCollection = new ArrayList();

                for (Rating r : ratings){
                    if(movie.getMovieId() == r.getMovieId()){
                        ratingCollection.add(r);
                    }
                }
                movie.setRatings(ratingCollection);
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
