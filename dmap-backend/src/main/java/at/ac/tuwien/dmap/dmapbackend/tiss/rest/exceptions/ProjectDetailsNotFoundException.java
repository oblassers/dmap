package at.ac.tuwien.dmap.dmapbackend.tiss.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectDetailsNotFoundException extends RuntimeException {

    public ProjectDetailsNotFoundException() {
    }

    public ProjectDetailsNotFoundException(String message) {
        super(message);
    }
}
