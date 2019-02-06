package at.ac.tuwien.dmap.dmapbackend.tiss.service.error;

import at.ac.tuwien.dmap.dmapbackend.tiss.rest.exceptions.TissErrorResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class TissResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(TissResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return ( httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||
                httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    /**
     * In case TISS returns client (4xx) or server errors (5xx) throw a TISS error response exception.
     * @param httpResponse
     * @throws IOException
     */
    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

        String message = String.format("Error response from TISS: %s, %s",
                httpResponse.getRawStatusCode(), httpResponse.getStatusText());

        log.info(message);
        throw new TissErrorResponseException(message);
    }
}
