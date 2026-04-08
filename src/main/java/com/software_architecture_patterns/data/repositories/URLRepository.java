package com.software_architecture_patterns.data.repositories;

import com.software_architecture_patterns.data.models.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    URL findByShortCode(String shortCode);
    URL findByOriginalUrl(String originalUrl);
    boolean existsByOriginalUrl(String originalUrl);
    boolean existsByShortCode(String shortCode);
}
