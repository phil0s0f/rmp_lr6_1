package com.example.rmp_lr6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentSendDataListener {
    public static final String TEXT_KEY = "TEXT";
    String text = "Сотрудник 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) text = extras.getString(TEXT_KEY);
    }

    @Override
    public void onSendData(String text) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isVisible()) fragment.setText(text);
        else {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.TEXT_KEY, text);
            //startActivity(intent);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                String accessMessage = data.getStringExtra(TEXT_KEY);
                ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
                if (fragment != null) fragment.setText(accessMessage);
            }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) text = extras.getString(TEXT_KEY);
//        ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
//        if (fragment != null) fragment.setText(text);
//    }


}