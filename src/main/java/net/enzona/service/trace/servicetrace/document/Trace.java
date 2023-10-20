package net.enzona.service.trace.servicetrace.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trace")
public class Trace {
    @Id
    private String uuid;
    private String createAt;
    //
    private String ip;
    private String userName;
    private String path;
    private String endpoint;
    private String browser;
    private String device;
}
