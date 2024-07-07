package com.patrik.lolstatikk.dto;

public enum ParType {

    BLOOD_WELL("Blood Well"),
    ENERGY("Energy"),
    NONE("None"),
    COURAGE("Courage"),
    RAGE("Rage"),
    FURY("Fury"),
    HEAT("Heat"),
    FLOW("Flow"),
    CRIMSON_RUSH("Crimson Rush"),
    FEROCITY("Ferocity"),
    SHIELD("Shield"),
    MANA("Mana");

    public final String value;

    ParType(String value) {
        this.value = value;
    }
}
