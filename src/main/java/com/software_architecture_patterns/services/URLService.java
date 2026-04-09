package com.software_architecture_patterns.services;

import com.software_architecture_patterns.data.models.URL;
import com.software_architecture_patterns.data.repositories.URLRepository;
import com.software_architecture_patterns.dtos.requests.ShortCodeRequestDto;
import com.software_architecture_patterns.dtos.requests.UrlRequestDto;
import com.software_architecture_patterns.dtos.responses.ShortCodeResponseDto;
import com.software_architecture_patterns.dtos.responses.UrlResponseDto;
import com.software_architecture_patterns.exceptons.NonExistingShortCodeException;
import com.software_architecture_patterns.utils.CodeGenerator;
import com.software_architecture_patterns.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    public ShortCodeResponseDto shortUrl(UrlRequestDto requestDto){
        if (urlRepository.existsByOriginalUrl(requestDto.getOriginalUrl())){
            URL oldUrl = urlRepository.findByOriginalUrl(requestDto.getOriginalUrl());
            return Mappers.shortCodeResponse(oldUrl);
        }

        URL newUrl = Mappers.urlRequest(requestDto);
        if(urlRepository.existsByShortCode(newUrl.getShortCode())){
            newUrl = Mappers.urlRequest(requestDto);
        }
        urlRepository.save(newUrl);
        return Mappers.shortCodeResponse(newUrl);
    }

    public UrlResponseDto getOriginalUrl(ShortCodeRequestDto requestDto){
        if(urlRepository.existsByShortCode(requestDto.getShortCode())){
            URL oldUrl = urlRepository.findByShortCode(requestDto.getShortCode());
            return Mappers.urlResponse(oldUrl);
        }
        else throw new NonExistingShortCodeException("Sorry, this short code does not exist");
    }



}
