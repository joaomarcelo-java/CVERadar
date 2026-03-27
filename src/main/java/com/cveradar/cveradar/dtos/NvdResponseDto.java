package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class NvdResponseDto {
    @JsonProperty("vulnerabilities")
    private List<NvdVulnerabilityDto> vulnerabilities;
}