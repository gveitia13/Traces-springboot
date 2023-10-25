package net.enzona.service.trace.servicetrace.controller;

import net.enzona.service.trace.servicetrace.document.Trace;
import net.enzona.service.trace.servicetrace.document.TraceDTO;
import net.enzona.service.trace.servicetrace.service.TraceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trace")
public class TraceController {
    private final TraceService traceService;

    public TraceController(TraceService traceService) {
        this.traceService = traceService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TraceDTO traceDTO) {
        return this.traceService.create(traceDTO);
    }

    @GetMapping
    public ResponseEntity list() {
        return this.traceService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity findByUUID(@PathVariable("uuid") String uuid) {
        return this.traceService.findByUUID(uuid);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity delete(@PathVariable("uuid") String uuid) {
        return this.traceService.delete(uuid);
    }
}
