package com.patrik.lolstatikk.service;

import com.patrik.lolstatikk.dto.ChampionTableDto;

import java.io.IOException;
import java.util.List;

public interface ChampionService {

    String saveChampions(String json) throws IOException;

    List<ChampionTableDto> findAllChampions(String version);

    List<ChampionTableDto> findAllSorted(String sortField, String sortDirection);

}
