package com.software_architecture_patterns.services;

import com.software_architecture_patterns.data.models.URL;
import com.software_architecture_patterns.data.repositories.URLRepository;
import com.software_architecture_patterns.exceptons.NonExistingShortCodeException;
import com.software_architecture_patterns.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    public String shortUrl(String originalUrl){
        if (urlRepository.existsByOriginalUrl(originalUrl)){
            URL oldUrl = urlRepository.findByOriginalUrl(originalUrl);
            return oldUrl.getShortCode();
        }

        String newShortCode = CodeGenerator.generate();
        if(urlRepository.existsByShortCode(newShortCode)){
            newShortCode = CodeGenerator.generate();
        }
        URL newUrl = new URL();
        newUrl.setOriginalUrl(originalUrl);
        newUrl.setShortCode(newShortCode);
        newUrl.setCreatedAt(LocalDateTime.now());
        urlRepository.save(newUrl);
        return newShortCode;
    }

    public String getOriginalUrl(String shortCode){
        if(urlRepository.existsByShortCode(shortCode)){
            URL oldUrl = urlRepository.findByShortCode(shortCode);
            return oldUrl.getOriginalUrl();
        }
        else throw new NonExistingShortCodeException("Sorry, this short code does not exist");
    }



}
