package com.patrik.lolstatikk.service;

import com.patrik.lolstatikk.entity.PropertiesEntity;
import com.patrik.lolstatikk.repository.PropertiesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.patrik.lolstatikk.util.LolStatikkConstants.LATEST_VERSION;

@Log4j2
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    private DDragonRiotApiService dDragonRiotApiService;

    @Override
    public void updateVersion(String version) {
        PropertiesEntity properties = new PropertiesEntity();
        properties.setKey(LATEST_VERSION);
        properties.setValue(version);
        properties.setUpdated(LocalDateTime.now());

        propertiesRepository.save(properties);
    }

    @Override
    @Cacheable(value = "cacheLatest", cacheManager = "springCM")
    public String getVersion() {
        PropertiesEntity properties = propertiesRepository.findByKey(LATEST_VERSION);
        log.info("LOG");
        return Optional.ofNullable(properties.getValue()).orElseThrow(EntityNotFoundException::new);
    }

}
