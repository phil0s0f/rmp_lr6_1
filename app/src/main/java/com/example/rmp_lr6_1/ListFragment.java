package com.example.rmp_lr6_1;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }

    // вложенный интерфейс
    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener sendDataListener;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup cont, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, cont, false);
        Button b1 = view.findViewById(R.id.countWord);
        Button b2 = view.findViewById(R.id.showStat);
        Button b3 = view.findViewById(R.id.removeFirstWord);
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
        return view;
    }
}