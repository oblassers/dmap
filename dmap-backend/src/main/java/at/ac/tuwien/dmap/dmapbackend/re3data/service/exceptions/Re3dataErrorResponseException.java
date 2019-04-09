package at.ac.tuwien.dmap.dmapbackend.re3data.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Return HTTP status 404 - Not found in case re3data returns error codes.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Re3dataErrorResponseException extends RuntimeException  {

    public Re3dataErrorResponseException() {
        super();
    }

    public Re3dataErrorResponseException(String message) {
        super(message);
    }
}
