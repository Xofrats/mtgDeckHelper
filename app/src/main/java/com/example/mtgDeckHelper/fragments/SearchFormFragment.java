package com.example.mtgDeckHelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.liveDataViewModel;
import com.example.mtgDeckHelper.apiRelated.urlHandler;



public class SearchFormFragment extends Fragment {

    liveDataViewModel viewModel;
    EditText text;
    EditText cmc;
    EditText type;
    EditText color;



    public static SearchFormFragment newInstance() {
        SearchFormFragment fragment = new SearchFormFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_searchform, container, false);
        viewModel = new ViewModelProvider(this).get(liveDataViewModel.class);

        text =(EditText) rootView.findViewById(R.id.inputText);
        cmc = (EditText)rootView.findViewById(R.id.inputCMC);
        type = (EditText)rootView.findViewById(R.id.inputType);
        color = (EditText)rootView.findViewById(R.id.inputColor);

        Button btn = (Button) rootView.findViewById(R.id.button_search);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onClick_search_cards();
            }
        });

        return rootView;

}


    public void onClick_search_cards() {
        urlHandler handler = new urlHandler();
        if(!(text.getText().toString().equals(""))){
            handler.setText(text.getText().toString());
        }

        if(!(cmc.getText().toString().equals(""))){
            handler.setCmc(cmc.getText().toString());
        }

        if(!(type.getText().toString().equals(""))){
            handler.setType(type.getText().toString());
        }

        if(!(color.getText().toString().equals(""))){
            handler.setColours(color.getText().toString());
        }
        viewModel.search_cards(handler.generateUrl());

    }

}
