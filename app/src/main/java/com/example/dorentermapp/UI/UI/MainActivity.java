package com.example.dorentermapp.UI.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Database.Repository;
import com.example.dorentermapp.UI.Entity.Terms;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repository = new Repository(getApplication());
        Terms term = new Terms(1,"Software Dev", "10/10/20", "10/30/2021");
        repository.insert(term);

    }

    public void enterTerms(View view) {
        Intent intent = new Intent(MainActivity.this, TermsPage.class);
        startActivity(intent);

    }
}