package java.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ComparatorExample
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ComparatorExample {

    static class Obj{
         int a;
         int b;

         public Obj(int a){
            this.a=a;
         }
    }

    static class ObjAscComparator implements Comparator<Obj>{

        @Override
        public int compare(Obj o1, Obj o2) {
            return o1.a-o2.a;
        }
    }

     static class ObjDescComparator implements Comparator<Obj>{

        @Override
        public int compare(Obj o1, Obj o2) {
            return o2.a-o1.a;
        }
    }


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
