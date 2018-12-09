package openapi.vo;

import lombok.Data;

import java.net.URI;

@Data
public class CSVPersistentOutput {
    private URI location;
    private String type;
    private String description;
}