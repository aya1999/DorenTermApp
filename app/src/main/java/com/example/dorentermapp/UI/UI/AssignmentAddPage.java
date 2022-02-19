package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.Objects;

public class AssignmentAddPage extends AppCompatActivity {

    private Spinner spinnerDD;
    String name;
    String date;
    String type;
    EditText assignName;
    EditText assignDate;
    Spinner assignType;
    int courseID;
    int assignmentID;
    Repository repository;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_add_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //for type dropdown menu
        spinnerDD = findViewById(R.id.assignTypeDropdown);

        String[] types = getResources().getStringArray(R.array.types);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDD.setAdapter(adapter);


        assignDate=findViewById(R.id.assignmentstartdate);
        assignName=findViewById(R.id.assignmentname);
        assignType=findViewById(R.id.assignTypeDropdown);

        assignmentID = getIntent().getIntExtra("id", -1);
        courseID = getIntent().getIntExtra("courseid", -1);//-1???
        name = getIntent().getStringExtra("name");
        date = getIntent().getStringExtra("date");
        type = getIntent().getStringExtra("type");


        assignDate.setText(date);
        assignName.setText(name);
        //assignType.setAdapter(type);//have to fix

        repository = new Repository(getApplication());
    }

    public void saveAssignment(View view) {
        /*Assignments assignments;
        if (assignmentID == -1) {
            int newID = repository.getmAllAssignments().get(repository.getmAllAssignments().size() - 1).getAssignmentID() + 1;
            assignments = new Terms(newID, assignName.getText().toString(), assignDate.getText().toString(), assignType.getText().toString(), courseID);
            repository.insert(assignments);
        } else {
            assignments = new Terms(assignmentID, assignName.getText().toString(), assignDate.getText().toString(), assignType.getText().toString(), courseID );
            repository.update(assignments);
        }

         */
    }
}
