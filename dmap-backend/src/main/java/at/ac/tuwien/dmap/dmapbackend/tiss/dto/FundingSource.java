package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSource {

    private FundingType fundingType;

    private FunderName funderName;

    private List<FundingProgramInfo> program;

    public FundingSource() {
    }

    public FundingType getFundingType() {
        return fundingType;
    }

    public void setFundingType(FundingType fundingType) {
        this.fundingType = fundingType;
    }

    public FunderName getFunderName() {
        return funderName;
    }

    public void setFunderName(FunderName funderName) {
        this.funderName = funderName;
    }

    public List<FundingProgramInfo> getProgram() {
        return program;
    }

    public void setProgram(List<FundingProgramInfo> program) {
        this.program = program;
    }
}
