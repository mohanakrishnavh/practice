package java.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ComparatorExample
 * 
 * Demonstrates custom ordering with {@link Comparator}.
 *
 * <p>Unlike {@code Comparable}, comparators live outside the class being sorted, so the same
 * type can be ordered in several ways. Here the list is sorted ascending and then descending
 * by the {@code a} field.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ComparatorExample {

    /**
     * A simple value holder with no natural ordering.
     */
    static class Obj{
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
    }

    /**
     * Orders {@link Obj} instances by ascending {@code a}.
     */
    static class ObjAscComparator implements Comparator<Obj>{

        @Override
        public int compare(Obj o1, Obj o2) {
            return o1.a-o2.a;
        }
    }

     /**
      * Orders {@link Obj} instances by descending {@code a}.
      */
     static class ObjDescComparator implements Comparator<Obj>{

        @Override
        public int compare(Obj o1, Obj o2) {
            return o2.a-o1.a;
        }
    }


    /**
     * Sorts a list with each comparator and prints the result.
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

        list.sort(new ObjAscComparator());
        System.out.println("Ascending");
        list.forEach(obj -> System.out.println(obj.a));

        list.sort(new ObjDescComparator());
        System.out.println("Descending");
        list.forEach(obj -> System.out.println(obj.a));
    }
}
