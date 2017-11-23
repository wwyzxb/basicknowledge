package guavaapi.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import common.db.jpa.model.Student;
import common.db.jpa.service.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component("guavaCache2")
public class GuavaCache2 {
    private LoadingCache<Integer, Student> cache = null;
    @Resource
    private StudentService studentService;

    public void init() {
        cache = CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(10, TimeUnit.MINUTES).build(new CacheLoader<Integer, Student>() {
            @Override
            public Student load(Integer id) throws Exception {
                return getStudentInfoFromDb(id);
            }
        });
    }

    private Student getStudentInfoFromDb(Integer id) {
        return studentService.getStudentById(id);
    }

    public void testDataCache() {
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            for (int i = 1; i <= 10; i++) {
                try {
                    cache.get(i);
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Data from cache:" + (endTime - startTime) + "ms");
    }

    public void testDateNoneCache() {
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            for (int i = 1; i <= 10; i++) {
                getStudentInfoFromDb(i);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Data from db dreactly:" + (endTime - startTime) + "ms");
    }
}
