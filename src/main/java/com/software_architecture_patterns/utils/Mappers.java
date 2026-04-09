package com.software_architecture_patterns.utils;

import com.software_architecture_patterns.data.models.URL;
import com.software_architecture_patterns.dtos.requests.UrlRequestDto;
import com.software_architecture_patterns.dtos.responses.ShortCodeResponseDto;
import com.software_architecture_patterns.dtos.responses.UrlResponseDto;

import java.time.LocalDateTime;

public class Mappers {
    public static URL urlRequest(UrlRequestDto requestDto){
        URL url = new URL();
        url.setOriginalUrl(requestDto.getOriginalUrl());
        url.setShortCode(CodeGenerator.generate());
        url.setCreatedAt(LocalDateTime.now());
        return url;
    }

    public static ShortCodeResponseDto shortCodeResponse(URL url ){
        ShortCodeResponseDto responseDto =  new ShortCodeResponseDto();
        responseDto.setShortCode(url.getShortCode());
        return responseDto;
    }

    public static UrlResponseDto urlResponse(URL url){
        UrlResponseDto responseDto = new UrlResponseDto();
        responseDto.setOriginalUrl(url.getOriginalUrl());
        return responseDto;
    }
}
