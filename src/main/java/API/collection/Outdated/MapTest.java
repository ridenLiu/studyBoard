package API.collection.Outdated;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class MapTest {

    /**
     * Map
     */
    @Test
    public void MapTest1() {
        Map map = new HashMap();
        map.put("riden", 47);
        map.put("mubape", 7);
        map.put("bolt", 9);
        // 添加已经添加的key,会跟新值,并返回旧值
        System.out.println("map.put(\"bolt\",11): " + map.put("bolt", 11));
        System.out.println("containKey: " + map.containsKey("riden"));
        System.out.println("containValue: " + map.containsValue(11));
        // 遍历key
        Set keySet = map.keySet();
        for (Object obj : keySet) {
            System.out.println("遍历key: " + obj);
        }
        Object removeObj = map.remove("mubape");
        System.out.println("removeObj: " + removeObj);
        boolean isRemove = map.remove("riden", 47); // java8新方法
        System.out.println("isRemove: " + isRemove);
    }

    /**
     * java8 for map
     */
    @Test
    public void java8ForMap() {
        Map map = new HashMap();
        map.put("riden", 47);
        map.put("mubape", 7);
        map.put("bolt", 9);
        boolean isRemove = map.remove("mubape", 7); // 通过key-value键值对删除元素
        Object v1 = map.compute("riden", (obj1, obj2) -> obj1.toString().length() * (Integer.parseInt(obj2.toString())));
        System.out.println("v1: "+v1);
        System.out.println("after compute: "+map);

    }


}
