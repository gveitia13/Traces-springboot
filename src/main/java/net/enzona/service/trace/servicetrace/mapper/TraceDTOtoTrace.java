package net.enzona.service.trace.servicetrace.mapper;

import net.enzona.service.trace.servicetrace.document.Trace;
import net.enzona.service.trace.servicetrace.document.TraceDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TraceDTOtoTrace implements IMapper<TraceDTO, Trace> {

    @Override
    public Trace map(TraceDTO in) {
        Trace trace = new Trace();
        trace.setIp(in.getIp());
        trace.setPath(in.getPath());
        trace.setDevice(in.getPath());
        trace.setEndpoint(in.getEndpoint());
        trace.setBrowser(in.getBrowser());
        trace.setUserName(in.getUserName());
        trace.setCreateAt(String.valueOf(LocalDateTime.now()));
        trace.setUuid(UUID.randomUUID().toString());
        return trace;
    }
}
