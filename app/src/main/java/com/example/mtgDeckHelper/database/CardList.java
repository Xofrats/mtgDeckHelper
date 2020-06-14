package com.example.mtgDeckHelper.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CardList")
public class CardList {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String list;
    private String cardname;

    public CardList(String list, String cardname) {
        this.list = list;
        this.cardname = cardname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }
}
