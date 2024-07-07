package com.patrik.lolstatikk.service;

import java.io.IOException;
import java.util.List;

public interface DDragonRiotApiService {

    public List<String> getAllVersions();

    public String getLatestVersion();

    public String getChampions(String paramVersion) throws IOException;
}
