package collection.list;

import java.util.List;
import java.util.Vector;

/**
 * Created by yeqf on 2015/6/16.
 */
public class ListDemo02 {
    public static void main(String[] args) {
        List<String> lists = new Vector<>();
        lists.add("A");
        lists.add("B");
        lists.add("C");
        lists.add("D");

        for (int i = 0; i < lists.size(); i++) {
            System.out.println("traverse: " + lists.get(i));
        }

        System.out.println("是否包含 F: "+lists.contains("F"));
    }
}
