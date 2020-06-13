package com.example.mtgDeckHelper;

public class urlHandler {
    private String text;
    private String cmc;
    private String color;
    private String type;

    public void setText(String text) {
        this.text = text;
    }

    public void setCmc(String cmc) {
        this.cmc = cmc;
    }

    public void setColours(String colours) {
        this.color = colours;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String generateUrl(){
        String result = "https://api.scryfall.com/cards/search?order=cmc&q=";

        if (text != null){
        result += text + "+";
        }

        if (cmc != null){
            result += cmc + "+";
        }

        if (color != null){
            result += color + "+";
        }

        if (type != null){
            result += type + "+";
        }

        return result;
    }
}
