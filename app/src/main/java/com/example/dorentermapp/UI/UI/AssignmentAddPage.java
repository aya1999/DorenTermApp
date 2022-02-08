package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.dorentermapp.R;

import java.util.Objects;

public class AssignmentAddPage extends AppCompatActivity {

    private Spinner spinnerDD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_add_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //for type dropdown menu
        spinnerDD = findViewById(R.id.assignTypeDropdown);

        String[] type = getResources().getStringArray(R.array.types);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDD.setAdapter(adapter);
    }

    public void saveAssignment(View view) {
    }
}
