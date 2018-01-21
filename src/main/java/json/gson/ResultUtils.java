package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import utils.CommonUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/26
 **/
public class ResultUtils {
    private static final Gson GSON = new GsonBuilder().create();

    /**
     * 将Result对象转换成json字符串
     *
     * @param result
     * @return
     */
    public static String toJson(Result result) {
        return GSON.toJson(result);
    }

    /**
     * 将json字符串转换成相应的对象（这里的泛型类型为T）
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Result<T> fromJson(String json, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(Result.class, null, new Class[]{clazz});
        Result<T> result = GSON.fromJson(json, type);
        return result;
    }

    /**
     * 将Json字符串转换成相应的对象（这里的泛型类型为List）
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Result<List<T>> fromArrJson(String json, Class<T> clazz) {
        Type listType = new ParameterizedTypeImpl(List.class, null, new Class[]{clazz});
        Type type = new ParameterizedTypeImpl(Result.class, null, new Type[]{listType});
        Result<List<T>> result = GSON.fromJson(json, type);
        return result;
    }

    public static <T> T fromJsonToObj(String json, Class<T> clazz) {
        T obj = GSON.fromJson(json, clazz);
        return obj;
    }

    @Test
    public void testFromJsonToObj() {
        StudentVO studentVO = StudentVO.builder().setName("Vincent").setAge(26).build();
        String json = GSON.toJson(studentVO);
        CommonUtils.print(json);
        StudentVO obj = fromJsonToObj(json, StudentVO.class);
        System.out.println(obj);
    }
}
