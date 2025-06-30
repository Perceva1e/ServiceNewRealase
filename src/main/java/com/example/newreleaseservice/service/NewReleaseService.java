package com.example.newreleaseservice.service;

import com.example.newreleaseservice.dto.FilmDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewReleaseService {

    private final RestTemplate restTemplate;

    public List<FilmDTO> getNewReleases() {
        log.info("Fetching the last 5 films from servicedb");
        FilmDTO[] films = restTemplate.getForObject("http://localhost:8081/api/films", FilmDTO[].class);
        if (films == null || films.length == 0) {
            log.warn("No films found in servicedb");
            return List.of();
        }
        return Arrays.stream(films)
                .sorted((a, b) -> Long.compare(b.getId(), a.getId()))
                .limit(5)
                .collect(Collectors.toList());
    }
}