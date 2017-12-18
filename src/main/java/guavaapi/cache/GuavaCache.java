package guavaapi.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import common.db.jpa.model.Student;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 演示Guava的LodingCache的Demo，Guava Cache适用于以下场景：
 * 1.你愿意消耗一些内存空间来提升速度;
 * 2.你预料到某些键会被查询一次以上;
 * 3.缓存中存放的数据总量不会超出内存容量.
 */
public class GuavaCache {
    private final static int MAX_SIZE = 2;//缓存大小
    private final static int EXPIRE_TIME = 5;//失效时间
    private static Map<Integer, Student> database = Maps.newHashMap();
    private static LoadingCache<Integer, Student> cache;

    public static void initData() {
        Student student1 = new Student(1, "No.001", "Jone", "male", "18623099572", "ChongQing");
        Student student2 = new Student(2, "No.002", "Vincent", "male", "18623099572", "ChongQing");
        Student student3 = new Student(3, "No.003", "Lucy", "male", "18623099572", "ChongQing");
        Student student4 = new Student(4, "No.004", "Lily", "male", "18623099572", "ChongQing");
        Student student5 = new Student(5, "No.005", "Tom", "male", "18623099572", "ChongQing");

        database.put(student1.getId(), student1);
        database.put(student2.getId(), student2);
        database.put(student3.getId(), student3);
        database.put(student4.getId(), student4);
        database.put(student5.getId(), student5);
    }

    private static void initCacheLoader() {
        cache = CacheBuilder.newBuilder().maximumSize(MAX_SIZE).expireAfterWrite(EXPIRE_TIME, TimeUnit.SECONDS).build(new CacheLoader<Integer, Student>() {
            @Override
            public Student load(Integer id) throws Exception {
                return getFromDatabase(id);
            }
        });
    }


    private static Student getFromDatabase(Integer id) {
        return database.get(id);
    }

    public static void main(String[] args) {
        initData();
        initCacheLoader();
        try {
            //1.可以自动载入键值至缓存，比如调用了cache.get("1")之后结果就会缓存起来
            //2.当缓存器溢出时，采用最近最少使用原则进行替换
            System.out.println(cache.get(1));
            System.out.println(cache.get(2));
            System.out.println(cache.get(3));
            System.out.println(cache.get(10));
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

    }
}
