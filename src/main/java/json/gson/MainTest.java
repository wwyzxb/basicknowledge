package json.gson;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/26
 **/
public class MainTest {
    public static void main(String[] args) {
        StudentVO student = StudentVO.builder().setAge(12).setName("Vincent").setNo("NO.1").setTel("18623099572").build();
        StudentVO student1 = StudentVO.builder().setAge(13).setName("Jim").setNo("NO.2").setTel("15215140724").build();

        Result<StudentVO> result = new Result<StudentVO>(1, "success", student);
        String json = ResultUtils.toJson(result);
        Result<StudentVO> result1 = ResultUtils.fromJson(json,StudentVO.class);
        //Vincent
        System.out.println(result1.getData().getName());

        Result<List<StudentVO>> listResult=new Result<List<StudentVO>>(2,"success", Arrays.asList(student,student1));
        String json2=ResultUtils.toJson(listResult);
        Result<List<StudentVO>> result2=ResultUtils.fromArrJson(json2,StudentVO.class);
        //[{no=NO.1, name=Vincent, age=12.0, tel=18623099572}, {no=NO.2, name=Jim, age=13.0, tel=15215140724}]
        System.out.println(result2.getData());
    }
}
