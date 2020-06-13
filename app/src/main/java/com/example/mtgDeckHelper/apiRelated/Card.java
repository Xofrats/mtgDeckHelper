package com.example.mtgDeckHelper.apiRelated;

public class Card {
    private String name;
    private String mana_cost;
    private String cmc;
    private String type_line;
    private String oracle_text;
    private String colors;
    private String color_identity;
    private String keywords;
    private String[] image_uris;

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

    public String getMana_cost() {
        return mana_cost;
    }

    public String getType_line() {
        return type_line;
    }

    public String getOracle_text() {
        return oracle_text;
    }

    public String getColors() {
        return colors;
    }

    public String getColor_identity() {
        return color_identity;
    }

    public String getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", manaCost='" + mana_cost + '\'' +
                ", cmc=" + cmc +
                '}';
    }
}
