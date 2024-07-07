package com.patrik.lolstatikk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class ChampionDto {

    @Id
    private String id;

    @Id
    private String version;

    private String key;

    private String name;

    private String title;

    private String blurb;

    private Image image;

    private ChampionInfoDto info;

    @JsonProperty("partype")
    private String parType;

    private List<String> tags;

    private ChampionStatsDto stats;

    @Data
    public class Image {
        private String full;
        private String sprite;
        private String group;
        private int x;
        private int y;
        private int w;
        private int h;
    }

    @Data
    public class ChampionInfoDto {
        private String attack;
        private String defense;
        private String magic;
        private String difficulty;
    }

}


