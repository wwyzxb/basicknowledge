package json.gson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/26
 **/
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;
}
