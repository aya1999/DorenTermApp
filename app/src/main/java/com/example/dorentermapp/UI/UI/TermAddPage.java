package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.Objects;

public class TermAddPage extends AppCompatActivity {

    //goes here???
    String name;
    String start;
    String end;
    EditText termName;
    EditText termStart;
    EditText termEnd;
    int id = 1;
    Repository repository;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_add_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = getIntent().getStringExtra("name");//for what??
        start = getIntent().getStringExtra("start");//for what??
        end = getIntent().getStringExtra("end");//for what??

        termName=findViewById(R.id.termname);
        termStart=findViewById(R.id.termstartdate);
        termEnd=findViewById(R.id.termenddate);

        termName.setText(name);
        termStart.setText(start);
        termEnd.setText(end);

        repository = new Repository(getApplication());
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
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                //
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Send message title");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent,null);
                startActivity(shareIntent);
                return true;
            //case R.id.notify:
            //String dateFromScreen
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    public void enterTermDetails(View view) {//dont need i think
        Intent intent = new Intent(TermAddPage.this, TermsPage.class);
        startActivity(intent);
    }

    public void saveTerm(View view) {
        String termTitle =termName.getText().toString();
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
    }

    public void startdate(View view) {
    }


}