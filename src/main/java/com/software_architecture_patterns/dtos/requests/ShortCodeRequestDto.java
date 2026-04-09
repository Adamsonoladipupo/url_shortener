package com.software_architecture_patterns.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShortCodeRequestDto {
    private String shortCode;
}
