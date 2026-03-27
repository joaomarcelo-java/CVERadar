package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NvdCvssDataDto {
    @JsonProperty("baseScore")
    private double baseScore;
    @JsonProperty("baseSeverity")
    private String baseSeverity;
}
