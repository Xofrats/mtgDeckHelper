package com.example.mtgDeckHelper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class liveDataViewModel extends ViewModel {

    public MutableLiveData<String> notes;

    public liveDataViewModel(){
        notes = new MutableLiveData<>();
        notes.setValue("");
    }

    public void addNewNote(String cardname){
        String result = notes.getValue() + cardname + "\n";
        notes.setValue(result);
    }

    public void search_cards(String note){
        clearNotes();
        Controller controller = new Controller(this, note);
        controller.start();


    }


    public void clearNotes() {
        notes.setValue("");
    }
}
