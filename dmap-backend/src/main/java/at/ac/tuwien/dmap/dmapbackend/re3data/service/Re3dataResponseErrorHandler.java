package at.ac.tuwien.dmap.dmapbackend.re3data.service;

import at.ac.tuwien.dmap.dmapbackend.re3data.service.exceptions.Re3dataErrorResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class Re3dataResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(Re3dataResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return ( httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||
                httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    /**
     * In case re3data returns client (4xx) or server errors (5xx) throw an error response exceptions.
     * @param httpResponse
     * @throws IOException
     */
    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

        String message = String.format("Error response from re3data: %s, %s",
                httpResponse.getRawStatusCode(), httpResponse.getStatusText());

        log.info(message);
        throw new Re3dataErrorResponseException(message);
    }
}
