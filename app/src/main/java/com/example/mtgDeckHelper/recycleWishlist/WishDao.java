package com.example.mtgDeckHelper.recycleWishlist;


import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.ArrayList;


public class WishDao {

    private ArrayList<String> names;
    private static WishDao instance;

    private WishDao() {
        names = new ArrayList<>();
    }

    public static WishDao getInstance(){
        if(instance == null) {
            instance = new WishDao();
        }
        return instance;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void addName(String name) {
        names.add(name);

    }

    public void deleteWishlist() {

        names.clear();
    }


    public void deleteName(String name) {
        names.remove(name);
    }
}
