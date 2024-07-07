package com.patrik.lolstatikk.repository;

import com.patrik.lolstatikk.entity.ChampionEntity;
import com.patrik.lolstatikk.entity.ChampionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<ChampionEntity,ChampionKey> {

}
