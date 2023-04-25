package com.example.rmp_lr6_1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }
    private OnFragmentSendDataListener sendDataListener;
    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            sendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " не" + "реализует интерфейс OnFragmentSendDataListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }//метод для обновления текстового поля

    public void setText(String text) {
        TextView view = getView().findViewById(R.id.detailsText);
        view.setText(text);
        Button b1 = getView().findViewById(R.id.employe1);
        Button b2 = getView().findViewById(R.id.employe2);
        Button b3 = getView().findViewById(R.id.employe3);
        Button b4 = getView().findViewById(R.id.employe4);
        Button b5 = getView().findViewById(R.id.employe5);
        Button b6 = getView().findViewById(R.id.employe6);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {// получаем выбранный текст
                String text = ((Button) view).getText().toString();// Посылаем данные Activity
                sendDataListener.onSendData(text);
            }
        };
        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
        b5.setOnClickListener(listener);
        b6.setOnClickListener(listener);
    }


}