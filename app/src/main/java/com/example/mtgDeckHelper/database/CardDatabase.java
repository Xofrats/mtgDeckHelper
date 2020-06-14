package com.example.mtgDeckHelper.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mtgDeckHelper.apiRelated.Card;

@Database(entities = {CardList.class}, version = 1)
    public abstract class CardDatabase extends RoomDatabase {

        private static CardDatabase instance;

        public abstract CardDatabaseDAO CardDatabaseDAO();

        public static synchronized CardDatabase getInstance(Context context){
            if(instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        CardDatabase.class, "Card_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return instance;
        }
    }

