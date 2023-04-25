package com.example.rmp_lr6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentSendDataListener{

    public static final String TEXT_KEY = "TEXT";
    String text = "Выберите действие";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        if (extras != null) text = extras.getString(TEXT_KEY);
    }
    @Override
    public void onSendData(String text) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
        if (fragment != null && fragment.isVisible()) fragment.setText(text);
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra(MainActivity.TEXT_KEY, text);
            //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //startActivity(intent);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null) text = extras.getString(TEXT_KEY);
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment != null) fragment.setText(text);
    }
}