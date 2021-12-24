package ru.gb.androidcoursecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    public void numberButtonOnClick(View view) {
        Button button = (Button) view;
        if (display.getText().toString().equals("0")) {
            display.setText("");
        }
        display.setText(display.getText().toString() + button.getText().toString());
    }
}