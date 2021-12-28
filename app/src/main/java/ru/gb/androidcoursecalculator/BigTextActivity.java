package ru.gb.androidcoursecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BigTextActivity extends Activity {
    private CalcData calcData;
    private TextView display;
    private final static String KEY_CALC_DATA = "key_calc_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_text);
        display = findViewById(R.id.result);
        calcData = (CalcData) getIntent().getExtras().getParcelable(KEY_CALC_DATA);
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_CALC_DATA)) {
            calcData = (CalcData) savedInstanceState.getSerializable(KEY_CALC_DATA);
        }
        refreshDisplay();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.calcData = (CalcData) savedInstanceState.getParcelable(KEY_CALC_DATA);
        this.refreshDisplay();
    }

    private void refreshDisplay() {
        display.setText(calcData.getNumber1());
    }


}
