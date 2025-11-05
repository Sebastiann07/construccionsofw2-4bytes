package app.domain.services;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;
import org.springframework.stereotype.Service;

@Service
public class CreateVisit {

    private final VisitPort visitPort;

    public CreateVisit(VisitPort visitPort) {
        this.visitPort = visitPort;
    }

    public void createVisit(Visit visit) throws Exception {
        if (visit == null) {
            throw new Exception("Visit cannot be null.");
        }
        visitPort.save(visit);
    }
}
