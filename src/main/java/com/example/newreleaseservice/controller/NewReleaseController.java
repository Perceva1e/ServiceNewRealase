package com.example.newreleaseservice.controller;

import com.example.newreleaseservice.dto.FilmDTO;
import com.example.newreleaseservice.service.NewReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/new-releases")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "New Release API", description = "Endpoints for retrieving new movie releases")
public class NewReleaseController {

    private final NewReleaseService newReleaseService;

    @GetMapping
    @Operation(summary = "Get new releases", description = "Retrieves the 5 most recent films")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved new releases")
    })
    public List<FilmDTO> getNewReleases() {
        log.info("Fetching the last 5 films");
        return newReleaseService.getNewReleases();
    }
}