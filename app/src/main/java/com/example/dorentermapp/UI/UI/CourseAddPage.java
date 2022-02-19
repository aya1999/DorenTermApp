package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.Objects;

public class CourseAddPage extends AppCompatActivity {
    //EditText courseID;
    //EditText termID;

    String title;
    String start;
    String end;
    String status;
    String mname;
    String phone;
    String email;
    EditText courseTitle;
    EditText courseStartDate;
    EditText courseEndDate;
    EditText courseStatus;
    EditText mentorName;
    EditText mentorPhone;
    EditText mentorEmail;
    int courseID;
    int termID;
    Repository repository;
    @SuppressLint("RestrictedApi")
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_add_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        courseTitle=findViewById(R.id.coursename);
        courseStartDate=findViewById(R.id.coursestartdate);
        courseEndDate=findViewById(R.id.courseenddate);
        courseStatus=findViewById(R.id.coursestatus);
        mentorName=findViewById(R.id.mentorname);
        mentorPhone=findViewById(R.id.mentorphone);
        mentorEmail=findViewById(R.id.mentoremail);

        //..
        termID = getIntent().getIntExtra("TermID", -1);//is neg one ok?, neccessary??? (in course constructor)
        courseID = getIntent().getIntExtra("id", -1);
        title = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        status = getIntent().getStringExtra("status");
        mname = getIntent().getStringExtra("mentorname");
        phone = getIntent().getStringExtra("mentorphone");
        email = getIntent().getStringExtra("mentoremail");




        courseTitle.setText(title);
        courseStartDate.setText(start);
        courseEndDate.setText(end);
        courseStatus.setText(status);
        mentorName.setText(mname);
        mentorPhone.setText(phone);
        mentorEmail.setText(email);


        repository = new Repository(getApplication());
    }

    public void saveCourse(View view) {
        Courses courses;
        if (courseID == -1) {
            int newID = repository.getmAllCourses().get(repository.getmAllCourses().size() - 1).getCourseID() + 1;
            courses = new Courses(newID, courseTitle.getText().toString(), courseStartDate.getText().toString(), courseEndDate.getText().toString(), courseStatus.getText().toString(), mentorName.getText().toString(), mentorPhone.getText().toString(), mentorEmail.getText().toString(), termID);
            repository.insert(courses);
        } else {
            courses = new Courses(courseID, courseTitle.getText().toString(), courseStartDate.getText().toString(), courseEndDate.getText().toString(), courseStatus.getText().toString(), mentorName.getText().toString(), mentorPhone.getText().toString(), mentorEmail.getText().toString(), termID);
            repository.update(courses);
        }
    }

    public void AddAssessment(View view) {
        Intent intent = new Intent(CourseAddPage.this, AssignmentAddPage.class);
        startActivity(intent);
    }
}