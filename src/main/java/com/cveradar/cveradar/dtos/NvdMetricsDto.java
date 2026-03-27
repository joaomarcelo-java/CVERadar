package com.cveradar.cveradar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NvdMetricsDto {
    @JsonProperty("cvssMetricV31")
    List<NvdCvssMetricsV31Dto> cvssMetricsV31;

}
