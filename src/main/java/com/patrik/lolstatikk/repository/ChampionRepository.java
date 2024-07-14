package com.patrik.lolstatikk.repository;

import com.patrik.lolstatikk.entity.ChampionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<ChampionEntity,Long> {

    List<ChampionEntity> findAllByVersion(String version);

}
