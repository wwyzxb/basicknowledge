package guavaapi.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCache3 {
    private static LoadingCache<Integer, Object> cache;
    private static Map<Integer, Object> data = Maps.newHashMap();
    private static Integer _1MB = 1024 * 1024;

    public static void initData() {
        data.put(1, new byte[_1MB * 5]);
        data.put(2, new byte[_1MB * 5]);
        data.put(3, new byte[_1MB * 2]);
        data.put(4, new byte[_1MB * 2]);
        data.put(5, new byte[_1MB * 2]);
//        data.put(6, new byte[_1MB * 2]);
        cache = CacheBuilder.newBuilder().maximumSize(5).expireAfterWrite(100, TimeUnit.SECONDS).recordStats().build(new CacheLoader<Integer, Object>() {
            @Override
            public Object load(Integer key) throws Exception {
                return getData(key);
            }
        });
    }

    private static Object getData(Integer id) {
        return data.get(id);
    }

    public static void main(String[] args) {
        initData();
        try {
            Object obj1=cache.get(1);
            cache.get(2);
            cache.get(3);
            cache.get(4);
            cache.get(5);
            System.out.println(cache.stats().toString());
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

    }
}
