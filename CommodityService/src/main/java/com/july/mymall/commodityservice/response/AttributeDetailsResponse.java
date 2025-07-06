package com.july.mymall.commodityservice.response;

import com.july.mymall.commodityservice.dto.AttributeDTO;
import lombok.Builder;

import java.util.List;

@Builder
public class AttributeDetailsResponse {
    private List<AttributeDTO> attributes;
}
