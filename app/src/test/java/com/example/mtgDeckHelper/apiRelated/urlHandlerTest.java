package com.example.mtgDeckHelper.apiRelated;

import org.junit.Test;

import static org.junit.Assert.*;

public class urlHandlerTest {

    @Test
    public void generateUrl() {
        urlHandler url = new urlHandler();
        url.setCmc("4");
        url.setText("jace");

        String expected = "https://api.scryfall.com/cards/search?order=cmc&q=jace+cmc=4+";
        String actual = url.generateUrl();
        assertTrue(expected.equals(actual));
    }
}