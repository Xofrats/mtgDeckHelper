package com.example.mtgDeckHelper.recycleWishlist;

import java.util.ArrayList;

public class WishRepository {

    private WishDao wishDao;
    private static WishRepository instance;

    private WishRepository(){
        wishDao = WishDao.getInstance();
    }

    public static WishRepository getInstance(){
        if(instance == null)
            instance = new WishRepository();

        return instance;
    }

    public ArrayList<String> getNames(){
        return wishDao.getNames();
    }

    public void insert(String name) {
        wishDao.addName(name);
    }

    public void deleteWishlist(){
        wishDao.deleteWishlist();
    }

    public void deleteName(String name){
        wishDao.deleteName(name);
    }


}
