package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;

public class TermsDetailsPage extends AppCompatActivity {

    private Repository repository;
    @SuppressLint("RestrictedApi")//?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_details_page);

        repository = new Repository(getApplication());
        List<Courses> allCourses = repository.getmAllCourses();
        RecyclerView recyclerView = findViewById(R.id.courserecyclerview);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(allCourses);
    }

    public void AddCourse(View view) {
        Intent intent = new Intent(TermsDetailsPage.this, CourseAddPage.class);
        startActivity(intent);
    }
}