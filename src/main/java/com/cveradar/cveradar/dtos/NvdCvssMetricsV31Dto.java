package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NvdCvssMetricsV31Dto {
    @JsonProperty("NvdCvssDataDto")
    NvdCvssDataDto nvdCvssDataDto;
    @JsonProperty("exploitabilityScore")
    private double exploitabilityScore;
    @JsonProperty("impactScore")
    private double impactScore;
}
