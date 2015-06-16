package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yeqf on 2015/6/15.
 */
public class ListDemo {


    public static void main(String[] args) {
        List<String> lists = null;
        lists = new ArrayList<>();
        lists.add("A");
        lists.add("B");
        lists.add("B");

        for (int i = 0; i < lists.size(); i++) {
            System.out.println("traverse: "+lists.get(i));
        }

        lists.remove(1);

        for (String x : lists) {
            System.out.println("after remove:" + x);
        }

        System.out.println("0 的位置是: "+lists.get(0));

        /**
         * 返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
         */
        System.out.println("B 的索引: "+lists.indexOf("B"));

        System.out.println("集合是否为空：" + lists.isEmpty());


        /**
         * Iterator
         */
        Iterator<String> it = lists.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }

        /**
         * ListIterator可以以倒序遍历list，还可以add，和set
         */
        ListIterator<String> listIterator = lists.listIterator(2);
        listIterator.add("s");
        //listIterator.set("d");
        while (listIterator.hasPrevious()) {
            //listIterator.set("d");
            System.out.println("ListIterator:　" + listIterator.previous());
        }

        lists.add("C");
        lists.add("D");
        lists.add("E");
        lists.add("F");

        /**
         * toArray用法
         */
        String[] str = lists.toArray(new String[0]);

        for (int i = 0; i < str.length; i++) {
            System.out.println("Array: "+str[i]);
        }


        /**
         * 返回子列表 subList(int fromIndex, int toIndex)
         * 返回的子 List 不包含 toIndex 代表的元素
         */
        List<String> sublist = lists.subList(2, 5);
        for (int i = 0; i < sublist.size(); i++) {
            System.out.println("SubList: " + sublist.get(i));
        }
    }
}
