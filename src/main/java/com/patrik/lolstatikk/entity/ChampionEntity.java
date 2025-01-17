package com.patrik.lolstatikk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "champion")
public class ChampionEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String championId;

    private String version;

    private String key;

    private String name;

    private String title;

    private String parType;

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

