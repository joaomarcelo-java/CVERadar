package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NvdCveDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("descriptions")
    List<NvdDescriptionsDto> descricoesDto;
    @JsonProperty("vulnStatus")
    private String vulnStatus;
    @JsonProperty("metrics")
    private NvdMetricsDto metrics;
    @JsonProperty("cisaExploitAdd")
    private String cisaExploitAdd;
    @JsonProperty("cisaRequiredAction")
    private String cisaRequiredAction;

}
