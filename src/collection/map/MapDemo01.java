package collection.map;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by yeqf on 2015/6/18.
 */
public class MapDemo01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "yeqianfeng");
        map.put("key2", "nihao");
        map.put("key3", "jilindaxue");
        map.put("key4", "tongxingongcheng");
        map.put("key5", "xueyuan");
        map.put("key6", "14ban");

        System.out.println("hashCode: " + map.hashCode());
        System.out.println("映射的数量: " + map.size());

        /**
         * 得到指定key的值
         */
        System.out.println("-------------");
        String s = map.get("key1");
        System.out.println("得到key1的值为:" + s);

        /**
         * 判断key或者value是否存在
         */
        System.out.println("-------------");
        if (map.containsKey("key11")) {
            System.out.println("key11 存在");
        } else {
            System.out.println("key11 不存在");
        }

        if (map.containsValue("yeqianfeng")) {
            System.out.println("value(yeqianfeng) 存在");
        } else {
            System.out.println("value 不存在");
        }

        /**
         * 获得所有的key 或者value
         */
        System.out.println("-------------");
        System.out.println("得到所有的key");
        Set<String> set = map.keySet();
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("-------------");
        System.out.println("得到所有的value");
        Collection<String> c = map.values();
        Iterator<String> i2 = c.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());
        }

        /**
         * 将一个Map集合复制到另一个Map集合
         */
        Map<String, String> m = new HashMap<>();
        m.putAll(map);
        System.out.println("-------------");
        System.out.println("复制后的map: " + m.get("key2"));

    }
    
    
}
