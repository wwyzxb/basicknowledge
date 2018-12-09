package openapi.vo;

import lombok.Data;

/**
 * @author Vincent Wu
 * @date 2018/12/8 10:57
 */
@Data
public class QueryLog {
    Integer queryNum;
    Long queryStartTime;
    Long queryFinishedTime;
    Long writeFileStartTime;
    Long writeFileFinishedTime;
    Long entireExeStartTime;
    Long entireExeFinishedTime;
    String condition;
}
