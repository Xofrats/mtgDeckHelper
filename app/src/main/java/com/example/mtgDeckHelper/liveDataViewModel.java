package com.example.mtgDeckHelper;

import androidx.lifecycle.ViewModel;

import com.example.mtgDeckHelper.apiRelated.Card;
import com.example.mtgDeckHelper.apiRelated.Controller;

import java.util.List;

public class liveDataViewModel extends ViewModel {
    Controller controller = new Controller(this);
    CardRepository cardRepository = CardRepository.getInstance();

    public liveDataViewModel() {
    }

    public void search_cards(String note){

        controller.setSearchNote(note);
        controller.start();
    }

    public void update_cards(List<Card> cards){
        cardRepository.deleteCards();
        for (Card card: cards
             ) {
         cardRepository.insert(card);
        }
    }

    public List<Card> getCards(){
        return cardRepository.getCards();
    }


}
