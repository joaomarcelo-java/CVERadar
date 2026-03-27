package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NvdDescriptionsDto {
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("value")
    private String value;
}
