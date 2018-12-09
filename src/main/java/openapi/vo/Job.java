package openapi.vo;

import lombok.Data;
import openapi.vo.result.Table;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
public class Job {
    private String user;
    private String query;
    private UUID uuid;
    private CSVPersistentOutput output;
    private  JobState state;
    private Set<Table> tablesUsed;
    private Map<String, Object> usermeta;
    private Date queryStarted ;
    private Date queryFinished;
}





