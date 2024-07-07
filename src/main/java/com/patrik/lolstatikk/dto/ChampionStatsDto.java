package com.patrik.lolstatikk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChampionStatsDto {

    @JsonProperty("hp")
    private float hp;

    @JsonProperty("hpperlevel")
    private float hpPerLevel;

    @JsonProperty("mp")
    private float mp;

    @JsonProperty("mpperlevel")
    private float mpPerLevel;

    @JsonProperty("movespeed")
    private float moveSpeed;

    @JsonProperty("armor")
    private float armor;

    @JsonProperty("armorperlevel")
    private float armorPerLevel;

    @JsonProperty("spellblock")
    private float magicResist;

    @JsonProperty("spellblockperlevel")
    private float magicResistPerLevel;

    @JsonProperty("attackrange")
    private float attackRange;

    @JsonProperty("hpregen")
    private float hpRegen;

    @JsonProperty("hpregenperlevel")
    private float hpRegenPerLevel;

    @JsonProperty("mpregen")
    private float mpRegen;

    @JsonProperty("mpregenperlevel")
    private float mpRegenPerLevel;

    @JsonProperty("crit")
    private float crit;

    @JsonProperty("critperlevel")
    private float critPerLevel;

    @JsonProperty("attackdamage")
    private float attackDamage;

    @JsonProperty("attackdamageperlevel")
    private float attackDamagePerLevel;

    @JsonProperty("attackspeedperlevel")
    private float attackSpeedPerLevel;

    @JsonProperty("attackspeed")
    private float attackSpeed;

}
