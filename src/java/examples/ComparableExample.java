package java.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ComparableExample
 * 
 * Demonstrates natural ordering with {@link Comparable}.
 *
 * <p>{@code Obj} implements {@code Comparable<Obj>} so that {@code Collections.sort(list)}
 * orders instances by their {@code a} field without needing a separate comparator.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ComparableExample {

    /**
     * A simple value holder whose natural ordering is ascending by {@code a}.
     */
    static class Obj implements Comparable<Obj> {
         int a;
         int b;

         /**
          * Creates an object with the given sort key.
          *
          * @param a the value used for ordering
          */
         public Obj(int a){
            this.a=a;
         }

        @Override
        public int compareTo(Obj o) {
            return a-o.a;
        }
    }


    /**
     * Sorts a list using the natural ordering and prints it.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        List<Obj> list = new ArrayList<>();

        list.add(new Obj(10));
        list.add(new Obj(9));
        list.add(new Obj(4));
        list.add(new Obj(5));
        list.add(new Obj(7));

        Collections.sort(list);

        list.forEach(obj -> System.out.println(obj.a));
    }
}
