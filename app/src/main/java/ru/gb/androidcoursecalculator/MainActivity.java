package ru.gb.androidcoursecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private CalcData calcData;
    private final static String KEY_CALC_DATA = "key_calc_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.calculation_result_text_view);
        calcData = new CalcData();
        display.setText(calcData.getNumber1());
    }

    public void numberButtonOnClick(View view) {
        Button button = (Button) view;
        calcData.addNumber1(button.getText().toString());
        this.refreshDisplay();
    }

    public void CButtonOnClick(View view) {
        calcData.resetNumber1();
        this.refreshDisplay();
    }

    public void DelButtonOnClick(View view) {
        calcData.deleteLastDigit();
        this.refreshDisplay();
    }

    public void minusButtonOnClick(View view) {
        calcData.minus();
        this.refreshDisplay();
    }

    public void commaButtonOnClick(View view) {
        calcData.comma();
        this.refreshDisplay();
    }

    public void openBigTextScreen(View view) {
        Intent intent = new Intent(this, BigTextActivity.class);
        intent.putExtra(KEY_CALC_DATA, calcData);
        startActivity(intent);
    }

    private void refreshDisplay() {
        display.setText(this.calcData.getNumber1());
    }

    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(KEY_CALC_DATA, calcData);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.calcData = (CalcData) savedInstanceState.getParcelable(KEY_CALC_DATA);
        this.refreshDisplay();
    }
}