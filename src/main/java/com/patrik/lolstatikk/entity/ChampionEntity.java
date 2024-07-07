package com.patrik.lolstatikk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "champion")
@IdClass(ChampionKey.class)
public class ChampionEntity implements Serializable {

    @Id
    private String id;

    @Id
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

