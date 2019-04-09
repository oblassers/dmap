package at.ac.tuwien.dmap.dmapbackend.re3data.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RepositoryDetailsNotFoundException extends RuntimeException {

    public RepositoryDetailsNotFoundException() {
    }

    public RepositoryDetailsNotFoundException(String message) {
        super(message);
    }
}
