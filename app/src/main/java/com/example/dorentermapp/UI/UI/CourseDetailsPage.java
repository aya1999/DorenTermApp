package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;

import java.util.List;
import java.util.Objects;

public class CourseDetailsPage extends AppCompatActivity {



    private Repository repository;
    @SuppressLint("RestrictedApi")//?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        repository = new Repository(getApplication());
        List<Assignments> allAssignments = repository.getmAllAssignments();
        RecyclerView recyclerView = findViewById(R.id.AssignmentRecyclerView);
        final AssignmentAdapter assignmentAdapter = new AssignmentAdapter(this);
        recyclerView.setAdapter(assignmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        assignmentAdapter.setAssignments(allAssignments);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void AddAssessment(View view) {
        Intent intent = new Intent(CourseDetailsPage.this, AssignmentAddPage.class);
        startActivity(intent);
    }
}
