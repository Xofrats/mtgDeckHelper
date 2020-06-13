package com.example.mtgDeckHelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mtgDeckHelper.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TextView notes;
    EditText newNote;
    liveDataViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(liveDataViewModel.class);
        notes = findViewById(R.id.viewResult);
        newNote = findViewById((R.id.editText));

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



        viewModel.notes.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                notes.setText(s);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    public void addNote(View view) {
        urlHandler urlHandler = new urlHandler();
        String note = newNote.getText().toString();
        viewModel.addNote(note);

    }

    public void clearNotes(View view) {
        viewModel.clearNotes();

    }
}
