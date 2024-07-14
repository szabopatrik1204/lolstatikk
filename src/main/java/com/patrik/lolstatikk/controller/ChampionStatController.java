package com.patrik.lolstatikk.controller;

import com.patrik.lolstatikk.dto.ChampionTableDto;
import com.patrik.lolstatikk.dto.PageRequestDto;
import com.patrik.lolstatikk.service.ChampionService;
import com.patrik.lolstatikk.service.DDragonRiotApiService;
import com.patrik.lolstatikk.service.PropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping("/champions")
@RequiredArgsConstructor
public class ChampionStatController {

    private static final String TEMP_LATEST_VERSION = "14.13.1";
    private static final String CHAMPION_TABLE_DTO = "ChampionTableDto";

    private final ChampionService championService;
    private final PropertyService propertyService;
    private final DDragonRiotApiService dDragonRiotApiService;

    @GetMapping("/updateLatestVersion")
    public String updateLatestVersion() throws IOException {

        String latestVersion = dDragonRiotApiService.getLatestVersion();
        propertyService.updateVersion(latestVersion);

        return latestVersion;
    }

    @GetMapping("/updateChampions")
    public String updateChampions(@RequestParam(required = false) String paramVersion) throws IOException {
        String version = Optional.ofNullable(paramVersion).orElse(TEMP_LATEST_VERSION);
        return championService.saveChampions(version);
    }

    @PostMapping("/sort")
    public ResponseEntity<List<ChampionTableDto>> getChampionsFiltered(@RequestBody PageRequestDto pageRequest) {
        List<ChampionTableDto> champions = championService.findAllSorted(pageRequest.getSortField(), pageRequest.getSortDirection());
        return new ResponseEntity<>(champions, HttpStatus.OK);
    }

    @GetMapping
    public String getChampionsPage() {
        return "champions"; // This returns the champions.html Thymeleaf template
    }

}
