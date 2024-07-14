package com.patrik.lolstatikk.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChampionTableDto {

    private String name;

    private String title;

    private String parType;

    private List<String> tags;

    private float hp;

    private float hpPerLevel;

    private float mp;

    private float mpPerLevel;

    private float moveSpeed;

    private float armor;

    private float armorPerLevel;

    private float magicResist;

    private float magicResistPerLevel;

    private float attackRange;

    private float hpRegen;

    private float hpRegenPerLevel;

    private float mpRegen;

    private float mpRegenPerLevel;

    private float crit;

    private float critPerLevel;

    private float attackDamage;

    private float attackDamagePerLevel;

    private float attackSpeedPerLevel;

    private float attackSpeed;


}
