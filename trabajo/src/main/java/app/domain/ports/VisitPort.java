package app.domain.ports;

import app.domain.model.Visit;

public interface VisitPort {
    void save(Visit visit) throws Exception;
}
