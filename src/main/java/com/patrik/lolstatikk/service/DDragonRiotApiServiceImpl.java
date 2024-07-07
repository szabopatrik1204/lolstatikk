package com.patrik.lolstatikk.service;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Log4j2
@Service
public class DDragonRiotApiServiceImpl implements DDragonRiotApiService {

    private static final String ddragonVersionsUri = "https://ddragon.leagueoflegends.com/api/versions.json";

    private static final String ddragonChampionsUriWithoutVersion = "http://ddragon.leagueoflegends.com/cdn/%s/data/en_US/champion.json";

    @Autowired
    private PropertyService propertyService;

    @Override
    public List<String> getAllVersions() {
        return getVersionList();
    }

    @Override
    public String getLatestVersion() {

        String latestVersion = getVersionList().getFirst();
        log.info(format("Latest version : %s", latestVersion));

        return latestVersion;
    }

    @Override
    public String getChampions(String paramVersion) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        String version = Optional.ofNullable(paramVersion).orElse(propertyService.getVersion());
        String championResultJson = restTemplate.getForObject(format(ddragonChampionsUriWithoutVersion, version), String.class);

        log.info(format("Champions version : %s", version));

        return championResultJson;
    }

    private List<String> getVersionList() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(ddragonVersionsUri, String.class);
        JSONArray resultJsonArray = new JSONArray(result);

        return resultJsonArray.toList().stream().map(Object::toString).toList();
    }

}
