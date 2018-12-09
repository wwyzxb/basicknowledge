package openapi.vo.result;

import lombok.Data;

/**
 * @author Vincent Wu
 * @date 2018/12/8 22:53
 */
@Data
public class OssResult {
    private int code;
    private String message;
    private String data;
}
