package com.example.rmp_lr6_1;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }//метод для обновления текстового поля

    public void setText(String text) {
        TextView view = getView().findViewById(R.id.detailsText);
        view.setText(text);

        Button button = getView().findViewById(R.id.buttonExecute);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputEditText = getView().findViewById(R.id.inputMessage);
                String inputText = inputEditText.getText().toString();
                switch (text) {
                    case "Вывести статистику":
                        showStat(inputText);
                        break;
                    case "Посчитать слова":
                        countWord(inputText);
                        break;
                    case "Удалить первое слово":
                        deleteFirstWord(inputText);
                        break;
                }
            }
        });
    }

    private void deleteFirstWord(String inputText) {
        //TextView outputView = getView().findViewById(R.id.outputMessage);
        EditText input = getView().findViewById(R.id.inputMessage);
        String[] words = inputText.split(" ");
        words[0] = "";
        inputText = String.join(" ", words).trim();
        input.setText(inputText);
        //outputView.setText(inputText);
    }

    private void countWord(String inputText) {
        TextView outputView = getView().findViewById(R.id.outputMessage);
        String[] words = inputText.split(" ");
        //можно ещё replace убрать знаки препинания
        outputView.setText("текст содержит следующее количество слов: " + words.length);

    }

    private void showStat(String inputText) {
        TextView outputView = getView().findViewById(R.id.outputMessage);
        int sogl = 0;
        int glas = 0;
        int other = 0;
        //Pattern soglPattern = Pattern.compile("(?iu)[бвгджзйклмнпрстфхцчшщ]");
        //Pattern glasPattern = Pattern.compile("(?iu)[аяуюоеёэиы]");
        Pattern soglPattern = Pattern.compile("(?iu)[BCDFGHJKLMNPQRSTVWXYZ]");
        Pattern glasPattern = Pattern.compile("(?iu)[AEIOU]");

        Matcher matcher = soglPattern.matcher(inputText);
        while (matcher.find()) {
            sogl++;
        }
        matcher = glasPattern.matcher(inputText);
        while (matcher.find()) {
            glas++;
        }
        other = inputText.length() - (glas + sogl);


        outputView.setText("Согласных – " + sogl + "\nГласных – " + glas + "\nДругих – " + other);
    }
}