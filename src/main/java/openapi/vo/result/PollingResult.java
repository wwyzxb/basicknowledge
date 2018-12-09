package openapi.vo.result;

import lombok.Data;
import openapi.vo.Job;

/**
 * @author Vincent Wu
 * @date 2018/12/7 20:47
 */
@Data
public class PollingResult {
    private int code;
    private String message;
    private Job data;
}
