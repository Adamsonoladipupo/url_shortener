package com.software_architecture_patterns.controllers;

import com.software_architecture_patterns.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<String> shortenedUrl(@RequestBody String originalUrl){
        String shortUrl = urlService.shortUrl(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable("shortCode") String shortCode){
        String originalUrl = urlService.getOriginalUrl(shortCode);
        originalUrl = originalUrl.replace("\"","");
        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();
    }



}
