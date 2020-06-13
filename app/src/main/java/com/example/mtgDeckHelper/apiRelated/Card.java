package com.example.mtgDeckHelper.apiRelated;

import java.util.Arrays;

public class Card {
    private String name;
    private String mana_cost;
    private String cmc;
    private String type_line;
    private String oracle_text;
    private String[] colors;
    private String[] color_identity;
    private String[] keywords;

    public Card() {
    }

    public String getName() {
        return name;
    }

    public String getManaCost() {
        return mana_cost;
    }

    public String  getCmc() {
        return cmc;
    }

    public String getType_line() {
        return type_line;
    }

    public String getOracle_text() {
        return oracle_text;
    }

    public String[] getColors() {
        return colors;
    }

    public String[] getColor_identity() {
        return color_identity;
    }

    public String[] getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", mana_cost='" + mana_cost + '\'' +
                ", cmc='" + cmc + '\'' +
                ", type_line='" + type_line + '\'' +
                ", oracle_text='" + oracle_text + '\'' +
                ", colors=" + Arrays.toString(colors) +
                ", color_identity=" + Arrays.toString(color_identity) +
                ", keywords=" + Arrays.toString(keywords) +
                '}';
    }
}
