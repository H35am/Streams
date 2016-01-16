import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class testing {
    public static void main(String[] args) {


        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");



        Stream<String> stream = items.stream();
        stream.filter(item -> item.startsWith("o"));

    }



}
