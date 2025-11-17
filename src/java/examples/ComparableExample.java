package java.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ComparableExample
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ComparableExample {

    static class Obj implements Comparable<Obj> {
         int a;
         int b;

         public Obj(int a){
            this.a=a;
         }

        @Override
        public int compareTo(Obj o) {
            return a-o.a;
        }
    }


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
