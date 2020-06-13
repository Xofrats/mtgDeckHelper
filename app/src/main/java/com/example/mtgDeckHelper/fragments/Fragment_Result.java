package com.example.mtgDeckHelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mtgDeckHelper.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment_Result extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static Fragment_Result newInstance() {
        Fragment_Result fragment = new Fragment_Result();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        return root;
    }
}