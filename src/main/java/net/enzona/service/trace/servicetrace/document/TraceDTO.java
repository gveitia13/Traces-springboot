package net.enzona.service.trace.servicetrace.document;

import lombok.Data;

@Data
public class TraceDTO {
    private String ip;
    private String userName;
    private String path;
    private String endpoint;
    private String browser;
    private String device;
}
