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

import java.util.HashMap;
import java.util.Map;


public class ListFragment extends Fragment {

    boolean first = true;
    Map<String, String[]> employeMap = new HashMap<String, String[]>();

    public ListFragment() {
        // Required empty public constructor
    }

    public void setText(String text) {
        TextView view = getView().findViewById(R.id.emloyeKey);
        view.setText(text);


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
    public void onResume () {
        super.onResume();
        TextView employe = getView().findViewById(R.id.emloyeKey);
        EditText fio = getView().findViewById(R.id.fioEmpoye);
        EditText post = getView().findViewById(R.id.postEmploye);
        String key = employe.getText().toString();
        if (employeMap.containsKey(key)) {
            String[] value;
            value = employeMap.get(key);
            fio.setText(value[0]);
            post.setText(value[1]);
        } else {
            fio.setText("");
            post.setText("");
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Button buttonSave = view.findViewById(R.id.buttonSave);
        Button b2 = view.findViewById(R.id.buttonSelectEmploye);
//        if (!first) {
//            TextView employe = getView().findViewById(R.id.emloyeKey);
//            String key = employe.getText().toString();
//            if (employeMap.containsKey(key)) {
//                String[] value;
//                value = employeMap.get(key);
//                EditText fio = getView().findViewById(R.id.fioEmpoye);
//                EditText post = getView().findViewById(R.id.postEmploye);
//                fio.setText(value[0]);
//                post.setText(value[1]);
//            }
//        }
        first = false;
//        TextView employe = getView().findViewById(R.id.emloyeKey);
//        String key = employe.getText().toString();
//        if (employeMap.containsKey(key)) {
//            String[] value;
//            value = employeMap.get(key);
//            EditText fio = getView().findViewById(R.id.fioEmpoye);
//            EditText post = getView().findViewById(R.id.postEmploye);
//            fio.setText(value[0]);
//            post.setText(value[1]);
//        }
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key;
                String[] value = new String[2];
                TextView employe = getView().findViewById(R.id.emloyeKey);
                EditText fio = getView().findViewById(R.id.fioEmpoye);
                EditText post = getView().findViewById(R.id.postEmploye);
                key = employe.getText().toString();
                value[0] = fio.getText().toString();
                value[1] = post.getText().toString();
                employeMap.put(key, value);
                employeMap.get(key);
                String test;

            }
        });
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {// получаем выбранный текст
                String text = ((Button) view).getText().toString();// Посылаем данные Activity
                sendDataListener.onSendData(text);
            }
        };
        b2.setOnClickListener(listener);
        return view;

    }
}