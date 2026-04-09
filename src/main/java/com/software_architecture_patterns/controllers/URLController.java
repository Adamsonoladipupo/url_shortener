package com.software_architecture_patterns.controllers;

import com.software_architecture_patterns.dtos.requests.ShortCodeRequestDto;
import com.software_architecture_patterns.dtos.requests.UrlRequestDto;
import com.software_architecture_patterns.dtos.responses.ShortCodeResponseDto;
import com.software_architecture_patterns.dtos.responses.UrlResponseDto;
import com.software_architecture_patterns.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin("*")
@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<String> shortenedUrl(@RequestBody UrlRequestDto requestDto){
        ShortCodeResponseDto responseDto = urlService.shortUrl(requestDto);
        return ResponseEntity.ok(responseDto.getShortCode());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable("shortCode") ShortCodeRequestDto shortCode){
        UrlResponseDto originalUrl = urlService.getOriginalUrl(shortCode);
        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl.getOriginalUrl()))
                .build();
    }
}
