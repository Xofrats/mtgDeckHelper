package com.example.mtgDeckHelper;

import java.util.ArrayList;

public class api_response_succes {
    private String object;
    private String code;
    private int status;
    private String details;

    private int total_cards;
    private boolean has_more;
    private ArrayList<Card> data;

    public api_response_succes() {
    }

    public String getObject() {
        return object;
    }

    public int getTotal_cards() {
        return total_cards;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public ArrayList<Card> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "cards{" +
                "object='" + object + '\'' +
                ", total_cards=" + total_cards +
                ", has_more=" + has_more +
                ", data=" + data +
                '}';
    }
}
