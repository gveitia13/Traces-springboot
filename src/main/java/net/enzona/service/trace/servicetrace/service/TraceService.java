package net.enzona.service.trace.servicetrace.service;

import net.enzona.service.trace.servicetrace.document.Trace;
import net.enzona.service.trace.servicetrace.document.TraceDTO;
import net.enzona.service.trace.servicetrace.mapper.TraceDTOtoTrace;
import net.enzona.service.trace.servicetrace.repository.TraceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraceService {
    private final TraceRepository traceRepository;
    private final TraceDTOtoTrace mapper;

    public TraceService(TraceRepository traceRepository, TraceDTOtoTrace mapper) {
        this.traceRepository = traceRepository;
        this.mapper = mapper;
    }

    public Trace create(TraceDTO traceDTO) {
        Trace trace = mapper.map(traceDTO);
        return this.traceRepository.save(trace);
//        return new ResponseEntity(this.traceRepository.save(trace), HttpStatus.CREATED);
    }

    public List<Trace> findAll() {
        return this.traceRepository.findAll();
    }

    public ResponseEntity findByUUID(String uuid) {
//        Optional<Trace> optionalTrace = this.traceRepository.findById(uuid);
        return traceRepository.findById(uuid)
                .map(trace -> new ResponseEntity<>(trace, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity delete(String uuid) {
        Optional<Trace> optionalTrace = this.traceRepository.findById(uuid);
        if (optionalTrace.isPresent()) {
            traceRepository.deleteById(uuid);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
