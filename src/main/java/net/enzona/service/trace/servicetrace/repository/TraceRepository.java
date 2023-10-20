package net.enzona.service.trace.servicetrace.repository;

import net.enzona.service.trace.servicetrace.document.Trace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TraceRepository extends MongoRepository<Trace, String> {

}
