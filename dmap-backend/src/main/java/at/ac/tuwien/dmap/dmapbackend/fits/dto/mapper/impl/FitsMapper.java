package at.ac.tuwien.dmap.dmapbackend.fits.dto.mapper.impl;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.AnalysisResult;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.FormatIdentifier;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.Fits;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.FitsMetadataType;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.IdentificationType;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.mapper.DTOMapper;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import java.util.Optional;

/**
 * Maps the response from FITS to a simpler object.
 * The mapping considers the FITS documentation from https://projects.iq.harvard.edu/fits/fits-xml
 */
@Component
public class FitsMapper implements DTOMapper<AnalysisResult, Fits> {
    private static final String UNKNOWN = "unknown";

    @Override
    public AnalysisResult fromDTO(Fits dto) {

        AnalysisResult result = new AnalysisResult();
        IdentificationType.Identity identity = getMajorityVoteIdentity(dto);
        result.setFormat(getFormat(identity));
        result.setMimeType(getMimeType(identity));
        result.setFormatIdentifier(getFormatIdentifier(identity));
        result.setSize(getSize(dto));

        return result;
    }

    /**
     * If FITS tools disagree on a files' identity there is a conflict. This methods returns
     * the identity most tools agree on, or the first one in case there is no majority vote.
     * @param dto
     * @return identity where most tools agree
     */
    private IdentificationType.Identity getMajorityVoteIdentity(Fits dto) {

        if(dto.getIdentification().getIdentity().size() == 1) {
            return dto.getIdentification().getIdentity().get(0);
        }
        else if(dto.getIdentification().getStatus().value().equals("CONFLICT")) {
            int maxNumberOfTools = 0;
            IdentificationType.Identity majorityVoteIdentity = null;
            for (IdentificationType.Identity identity : dto.getIdentification().getIdentity()) {
                if(identity.getTool().size() > maxNumberOfTools) {
                    maxNumberOfTools = identity.getTool().size();
                    majorityVoteIdentity = identity;
                }
            }
            return majorityVoteIdentity;
        }
        return null;
    }

    private String getFormat(IdentificationType.Identity identity) {

        if(identity == null) {
            return UNKNOWN;
        }
        return identity.getFormat();
    }

    private String getMimeType(IdentificationType.Identity identity) {

        if(identity == null) {
            return UNKNOWN;
        }
        return identity.getMimetype();
    }

    private FormatIdentifier getFormatIdentifier(IdentificationType.Identity identity) {

        FormatIdentifier formatIdentifier = new FormatIdentifier(UNKNOWN, UNKNOWN);

        if(identity == null || identity.getExternalIdentifier().isEmpty()) {
            return formatIdentifier;
        } else {
            formatIdentifier.setId(identity.getExternalIdentifier().get(0).getValue());
            formatIdentifier.setType(identity.getExternalIdentifier().get(0).getType());
        }
        return formatIdentifier;
    }

    private Long getSize(Fits dto) {

        if(dto.getFileinfo() == null || dto.getFileinfo().getFileInfoElements().isEmpty()){
            return null;
        }

        Optional<JAXBElement<FitsMetadataType>> sizeElement =
                dto.getFileinfo().getFileInfoElements().stream().
                        filter(ele -> ele.getName().getLocalPart().equals("size")).findFirst();

        if(sizeElement.isPresent()) {
            return Long.parseLong(sizeElement.get().getValue().getValue());
        }

        return null;
    }
}
