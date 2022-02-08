package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;
import java.util.Objects;

public class TermsPage extends AppCompatActivity {

    private Repository repository;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        repository=new Repository(getApplication());
        List<Terms> allThings = repository.getmAllThings();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final ThingAdapter thingAdapter = new ThingAdapter(this);
        recyclerView.setAdapter(thingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        thingAdapter.setThings(allThings);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.refresh:
                repository=new Repository(getApplication());
                List<Terms> allThings = repository.getmAllThings();
                final ThingAdapter thingAdapter = new ThingAdapter(this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setAdapter(thingAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                thingAdapter.setThings(allThings);
        }
        return super.onOptionsItemSelected(item);
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_recyclerview, menu);
        return true;
    }

    public void AddTerms(View view) {
        Intent intent = new Intent(TermsPage.this, TermAddPage.class);
        startActivity(intent);
    }
}