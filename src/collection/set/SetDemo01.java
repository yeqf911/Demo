package collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yeqf on 2015/6/17.
 *
 */
public class SetDemo01 {

    /**
     * 可见Set集合中的元素是不能有重复的
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set;
        /**
         * HashSet是不能保证元素是有序的，他只是按照元素的哈希值来给元素安排存储单元
         */
        set = new HashSet<>();
        set.add("A");
        set.add("BF");
        set.add("C");
        set.add("F");
        set.add("EG");
        set.add("D");
        set.add("A");

        set.remove("D");
        System.out.println(set);


        /**
         * 而TreeSet是有序的
         */
        Set<String> set1 = new TreeSet<>();
        set1.add("ADB");
        set1.add("BA");
        set1.add("C");
        set1.add("F");
        set1.add("E");
        set1.add("D");
        set1.add("AB");
        System.out.println(set1);
    }
}
