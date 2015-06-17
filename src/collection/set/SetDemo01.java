package collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yeqf on 2015/6/17.
 */
public class SetDemo01 {

    public static void main(String[] args) {
        Set<String> set;
        set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("F");
        set.add("E");
        set.add("D");
        set.add("A");

        set.remove("D");
        System.out.println(set);


        Set<String> set1 = new TreeSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("F");
        set1.add("E");
        set1.add("D");
        System.out.println(set1);
    }
}
