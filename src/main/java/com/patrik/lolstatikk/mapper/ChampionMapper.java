package com.patrik.lolstatikk.mapper;

import com.patrik.lolstatikk.dto.ChampionRequestDto;
import com.patrik.lolstatikk.dto.ChampionTableDto;
import com.patrik.lolstatikk.entity.ChampionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ChampionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "id", target = "championId")
    @Mapping(source = "stats.hp", target = "hp")
    @Mapping(source = "stats.hpPerLevel", target = "hpPerLevel")
    @Mapping(source = "stats.mp", target = "mp")
    @Mapping(source = "stats.mpPerLevel", target = "mpPerLevel")
    @Mapping(source = "stats.moveSpeed", target = "moveSpeed")
    @Mapping(source = "stats.armor", target = "armor")
    @Mapping(source = "stats.armorPerLevel", target = "armorPerLevel")
    @Mapping(source = "stats.magicResist", target = "magicResist")
    @Mapping(source = "stats.magicResistPerLevel", target = "magicResistPerLevel")
    @Mapping(source = "stats.attackRange", target = "attackRange")
    @Mapping(source = "stats.hpRegen", target = "hpRegen")
    @Mapping(source = "stats.hpRegenPerLevel", target = "hpRegenPerLevel")
    @Mapping(source = "stats.mpRegen", target = "mpRegen")
    @Mapping(source = "stats.mpRegenPerLevel", target = "mpRegenPerLevel")
    @Mapping(source = "stats.crit", target = "crit")
    @Mapping(source = "stats.critPerLevel", target = "critPerLevel")
    @Mapping(source = "stats.attackDamage", target = "attackDamage")
    @Mapping(source = "stats.attackDamagePerLevel", target = "attackDamagePerLevel")
    @Mapping(source = "stats.attackSpeedPerLevel", target = "attackSpeedPerLevel")
    @Mapping(source = "stats.attackSpeed", target = "attackSpeed")
    public ChampionEntity dtoToEntity(ChampionRequestDto dto);

    public List<ChampionEntity> dtosToEntities(List<ChampionRequestDto> dto);

    ChampionTableDto entityToTableDto(ChampionEntity entity);

    List<ChampionTableDto> entitiesToTableDtos(List<ChampionEntity> entities);

}
