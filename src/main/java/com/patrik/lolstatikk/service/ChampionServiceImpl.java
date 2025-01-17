package com.patrik.lolstatikk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrik.lolstatikk.dto.ChampionRequestDto;
import com.patrik.lolstatikk.dto.ChampionTableDto;
import com.patrik.lolstatikk.mapper.ChampionMapper;
import com.patrik.lolstatikk.repository.ChampionRepository;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ChampionServiceImpl implements ChampionService {

    private static final ChampionMapper CHAMPION_MAPPER = Mappers.getMapper(ChampionMapper.class);

    public ChampionServiceImpl(ChampionRepository championRepository, DDragonRiotApiService dDragonRiotApiService) {
        this.championRepository = championRepository;
        this.dDragonRiotApiService = dDragonRiotApiService;
    }

    private final ChampionRepository championRepository;

    private final DDragonRiotApiService dDragonRiotApiService;

    @Override
    public String saveChampions(String version) throws IOException {
        String resultJson = dDragonRiotApiService.getChampions(version);
        JSONObject jsonObject = new JSONObject(resultJson);
        JSONObject dataJson = jsonObject.getJSONObject("data");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(resultJson);
        List<ChampionRequestDto> championList = new ArrayList<>();
        for (String key : dataJson.keySet()) {
            championList.add(objectMapper.readValue(jsonNode.get("data").get(key).toPrettyString(), new TypeReference<>() {
            }));
        }
        championRepository.saveAll(CHAMPION_MAPPER.dtosToEntities(championList));

        return "";
    }

    @Override
    public List<ChampionTableDto> findAllChampions(String version) {
        return CHAMPION_MAPPER.entitiesToTableDtos(championRepository.findAllByVersion(version));
    }

    @Override
    public List<ChampionTableDto> findAllSorted(String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        return CHAMPION_MAPPER.entitiesToTableDtos(championRepository.findAll(sort));
    }


}
