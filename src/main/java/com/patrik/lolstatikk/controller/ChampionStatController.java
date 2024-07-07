package com.patrik.lolstatikk.controller;

import com.patrik.lolstatikk.service.ChampionService;
import com.patrik.lolstatikk.service.DDragonRiotApiService;
import com.patrik.lolstatikk.service.PropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ChampionStatController {

    private final ChampionService championService;
    private final PropertyService propertyService;
    private final DDragonRiotApiService dDragonRiotApiService;

    @GetMapping("/updateLatestVersion")
    public String updateLatestVersion() throws IOException {

        String latestVersion = dDragonRiotApiService.getLatestVersion();
        propertyService.updateVersion(latestVersion);

        return latestVersion;
    }

    @GetMapping("/getChampions")
    public String getChampions(@RequestParam(required = false) String paramVersion) throws IOException {
        String version = Optional.ofNullable(paramVersion).orElse("14.13.1");
        return championService.saveChampions(version);
    }

}
