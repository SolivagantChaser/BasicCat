package com.july.mymall.commodityservice.response;

import com.july.mymall.commodityservice.dto.AttributeDTO;
import lombok.Data;

import java.util.List;

@Data
public class AttributeDetailResponse {
    List<AttributeDTO> attributes;
}
