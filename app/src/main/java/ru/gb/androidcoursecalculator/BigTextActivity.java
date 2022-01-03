package ru.gb.androidcoursecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.gb.androidcoursecalculator.domain.CalculatorModel;

public class BigTextActivity extends Activity {
    private CalculatorModel calculatorModel;
    private TextView calculationResultTextView;
    private String resultString;

    private final static String KEY_CALC_MODEL = "key_calc_model";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_text);
        calculationResultTextView = findViewById(R.id.result_text_view);
        resultString = getIntent().getExtras().getString(KEY_CALC_MODEL);
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_CALC_MODEL)) {
            resultString = savedInstanceState.getString(KEY_CALC_MODEL);
        }
        calculationResultTextView.setText(resultString);
    }

    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putString(KEY_CALC_MODEL, resultString);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultString = savedInstanceState.getString(KEY_CALC_MODEL);
        updateResultTextView();
    }

    private void updateResultTextView() {
        calculationResultTextView.setText(resultString);
    }


}
