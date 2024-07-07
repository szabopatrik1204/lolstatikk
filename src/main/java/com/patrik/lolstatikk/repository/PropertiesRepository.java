package com.patrik.lolstatikk.repository;

import com.patrik.lolstatikk.entity.PropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<PropertiesEntity, String> {

    PropertiesEntity findByKey(String key);

}
