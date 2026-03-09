import java.util.*;

public class Iterators {

    public static void main(String[] args) {

        // Create ArrayList
        List<String> listStrings = new ArrayList<String>();

        // Add values
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");

        // Create Iterator
        Iterator<String> iterator = listStrings.iterator();

        // Loop through ArrayList
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----");

        // Create HashSet
        Set<String> names = new HashSet<>();

        names.add("Tom");
        names.add("Mary");
        names.add("Peter");
        names.add("Alice");

        // Create Iterator
        Iterator<String> iterator2 = names.iterator();

        // Loop through HashSet
        while (iterator2.hasNext()) {
            String name = iterator2.next();
            System.out.println(name);
        }
    }
}