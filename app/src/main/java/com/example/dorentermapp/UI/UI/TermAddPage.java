package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class TermAddPage extends AppCompatActivity {

    //goes here???
    String name;
    String start;
    String end;
    EditText termName;
    EditText termStart;
    EditText termEnd;
    int termID;
    Repository repository;
    //for date picker
    String myFormat;
    SimpleDateFormat sdf;
    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myCalendarStart = Calendar.getInstance();

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_add_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        termName=findViewById(R.id.termname);
        termStart=findViewById(R.id.termstartdate);
        termEnd=findViewById(R.id.termenddate);

        //for date picker (for start right now)
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        startDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub

                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, monthOfYear);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                updateLabelStart();
            }

        };

        termStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date date;
                //get value from other screen,but I'm going to hard code it right now
                String info=termStart.getText().toString();
                if(info.equals(""))info="02/10/22";
                try{
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(TermAddPage.this, startDate, myCalendarStart
                        .get(Calendar.YEAR), myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //end of date picker, need for notify

        termID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        termName.setText(name);
        termStart.setText(start);
        termEnd.setText(end);

        repository = new Repository(getApplication());

        //for course recylcler view
        List<Courses> allCourses = repository.getmAllCourses();
        RecyclerView recyclerView = findViewById(R.id.courserecyclerview);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(allCourses);


    }

    //also for date picker
    private void updateLabelStart() {
        //String myFormat = "MM/dd/yy"; //In which you need put here
        //SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        termStart.setText(sdf.format(myCalendarStart.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");//get from edit text
                //
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Send message title");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent,null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                String dateFromScreen = termStart.getText().toString();
                Date myDate=null;
                try {
                    myDate=sdf.parse(dateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger=myDate.getTime();
                Intent intent= new Intent(TermAddPage.this,MyReceiver.class);
                intent.putExtra("key","message I want to see");//need to change message
                PendingIntent sender=PendingIntent.getBroadcast(TermAddPage.this, ++MainActivity.numAlert,intent,0);
                AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);
                return true;
            //String dateFromScreen
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    /*public void enterTermDetails(View view) {//dont need i think
        Intent intent = new Intent(TermAddPage.this, TermsPage.class);
        startActivity(intent);
    }

     */

    public void saveTerm(View view) {

        Terms terms;
        if (termID == -1) {
            int newID = repository.getmAllThings().get(repository.getmAllThings().size() - 1).getTermID() + 1;
            terms = new Terms(newID, termName.getText().toString(), termStart.getText().toString(), termEnd.getText().toString());
            repository.insert(terms);
        } else {
            terms = new Terms(termID, termName.getText().toString(), termStart.getText().toString(), termEnd.getText().toString());
            repository.update(terms);
        }
        /*String termTitle =termName.getText().toString();
        String startDate =termStart.getText().toString();
        String endDate = termEnd.getText().toString();
        if (name==null) {
            Terms newThing = new Terms(++id, termTitle, startDate, endDate);
            repository.insert(newThing);
        }
        else{
            Terms oldThing = new Terms(getIntent().getIntExtra("id", -1),termTitle, startDate, endDate);
            repository.update(oldThing);
        }

         */
    }

    public void AddCourse(View view) {
        Intent intent = new Intent(TermAddPage.this, CourseAddPage.class);
        intent.putExtra("TermID", termID);
        intent.putExtra("id", -1);
        startActivity(intent);
    }

    //public void startdate(View view) { }


}