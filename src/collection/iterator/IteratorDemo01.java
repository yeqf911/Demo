package collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yeqf on 2015/6/18.
 */
public class IteratorDemo01 {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("B");
        lists.add("E");
        lists.add("A");
        lists.add("D");
        lists.add("C");
        lists.add("F");

        Iterator<String> iter = lists.iterator();

        System.out.println("before remove: " + lists.size());

        /**
         * 在 iterator的迭代操作中不能使用lists的操作，否则会出错。
         * 但是可以使用iterator的remove操作。
         */
        while (iter.hasNext()) {
            //lists.remove(3);
            String s = iter.next();
            if ("A".equals(s)) {

                // 在iterator中remove也会把list中的元素删除。
                iter.remove();
            } else {
                System.out.println(s);
            }
        }

        System.out.println("===========");
        System.out.println("after remove: " + lists.size());

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

}
