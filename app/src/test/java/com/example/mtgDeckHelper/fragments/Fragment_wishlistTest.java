package com.example.mtgDeckHelper.fragments;

import android.widget.TextView;

import com.example.mtgDeckHelper.database.CardList;

import org.junit.Test;

import static org.junit.Assert.*;

public class Fragment_wishlistTest {
    Fragment_wishlist fragment = Fragment_wishlist.newInstance();
    @Test
    public void getKelzorUrl() {
        CardList card = new CardList("wishlist", "gideon");
        String expected = "https://www.kelz0r.dk/magic/advanced_search_result.php?keywords=gideon&search_in_description=0";
        String actual = fragment.getKelzorUrl(card);
        assertTrue(expected.equals(actual));
    }

}