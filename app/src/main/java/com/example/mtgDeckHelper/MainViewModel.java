package com.example.mtgDeckHelper;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private List<String> notes;

    public MainViewModel(){
        notes = new ArrayList<>();
    }


    public List<String> getNotes(){
        return notes;
    }

    public void addNote(String note){
        notes.add(note);
    }

    public void clearNotes(){
        notes.clear();
    }
}
