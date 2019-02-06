package at.ac.tuwien.dmap.dmapbackend.tiss.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Return HTTP status 404 - Not found in case TISS returns error codes.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TissErrorResponseException extends RuntimeException  {

    public TissErrorResponseException() {
        super();
    }

    public TissErrorResponseException(String message) {
        super(message);
    }
}
