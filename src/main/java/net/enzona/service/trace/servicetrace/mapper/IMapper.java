package net.enzona.service.trace.servicetrace.mapper;

public interface IMapper<I, O> {
    public O map(I in);
}
