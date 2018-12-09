package openapi.vo.result;

import lombok.Data;

@Data
public class Table{
    private String connectorId;
    private String schema;
    private String table;
}