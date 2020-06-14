package com.example.mtgDeckHelper.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.List;

@Dao
public interface CardDatabaseDAO {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(CardList card);

    @Update
    void update(CardList card);

    @Delete
    void delete(CardList card);

    @Query("SELECT * FROM CardList")
    List<CardList> getCardlist();
}

