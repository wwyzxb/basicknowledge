package openapi.vo.result;

import lombok.Data;

import java.util.UUID;

/**
 * @Author: wuxiaobing
 * @Date 2018/6/14
 **/
@Data
public class ExeResult {
    private int code;
    private String message;
    private ExecutionSuccess data;

    @Data
    public static class ExecutionSuccess {
        public UUID uuid;
    }
}



