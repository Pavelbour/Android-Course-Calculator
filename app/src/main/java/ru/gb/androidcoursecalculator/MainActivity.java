package ru.gb.androidcoursecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

import java.util.List;

import ru.gb.androidcoursecalculator.domain.CalculatorModel;
import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;

public class MainActivity extends AppCompatActivity {
    private TextView calculationResultTextView;

    private Button digitOneButton;
    private Button digitTwoButton;
    private Button digitThreeButton;
    private Button digitFourButton;
    private Button digitFiveButton;
    private Button digitSixButton;
    private Button digitSevenButton;
    private Button digitEightButton;
    private Button digitNineButton;
    private Button digitZeroButton;
    private Button digitDotButton;

    private Button operationSubtractionButton;
    private Button operationAdditionButton;
    private Button operationMultiplicationButton;
    private Button operationDivisionButton;

    private Button clearDisplayButton;

    private  Button equalButton;

    private Button deleteLastCharButton;

    private CalculatorModel calculatorModel;
    private final static String KEY_CALC_MODEL = "key_calc_model";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorModel = new CalculatorModel();

        initViews();
        initListeners();
    }

    private void initViews() {
        calculationResultTextView = findViewById(R.id.calculation_result_text_view);

        digitOneButton = findViewById(R.id.digit_one_button);
        digitTwoButton = findViewById(R.id.digit_two_button);
        digitThreeButton = findViewById(R.id.digit_three_button);
        digitFourButton = findViewById(R.id.digit_four_button);
        digitFiveButton = findViewById(R.id.digit_five_button);
        digitSixButton = findViewById(R.id.digit_six_button);
        digitSevenButton = findViewById(R.id.digit_seven_button);
        digitEightButton = findViewById(R.id.digit_eight_button);
        digitNineButton = findViewById(R.id.digit_nine_button);
        digitZeroButton = findViewById(R.id.digit_zero_button);
        digitDotButton = findViewById(R.id.digit_dot_button);

        operationAdditionButton = findViewById(R.id.operation_addition_button);
        operationSubtractionButton = findViewById(R.id.operation_subtraction_button);
        operationMultiplicationButton = findViewById(R.id.operation_multiplication_button);
        operationDivisionButton = findViewById(R.id.operation_division_button);

        equalButton = findViewById(R.id.operation_equal_button);

        clearDisplayButton = findViewById(R.id.clear_display_button);
        deleteLastCharButton = findViewById(R.id.delete_last_char_button);
    }

    private void initListeners() {
        digitOneButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_1));
        digitTwoButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_2));
        digitThreeButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_3));
        digitFourButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_4));
        digitFiveButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_5));
        digitSixButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_6));
        digitSevenButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_7));
        digitEightButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_8));
        digitNineButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_9));
        digitZeroButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.NUM_0));
        digitDotButton.setOnClickListener(v -> onDigitalButtonClick(InputSymbol.DOT));

        operationSubtractionButton.setOnClickListener(v -> onOperationButtonClick(InputSymbol.MINUS));
        operationAdditionButton.setOnClickListener(v -> onOperationButtonClick(InputSymbol.PLUS));
        operationMultiplicationButton.setOnClickListener(v -> onOperationButtonClick(InputSymbol.MULTIPLICATION));
        operationDivisionButton.setOnClickListener(v -> onOperationButtonClick(InputSymbol.DIVISION));

        clearDisplayButton.setOnClickListener(v -> onClearButtonClick());
        deleteLastCharButton.setOnClickListener(v -> onDeleteButtonClick());

        equalButton.setOnClickListener(v -> onEqualButtonClick());
    }

    private void onEqualButtonClick() {
        showResult(this.calculatorModel.getResult());
    }

    private void onDigitalButtonClick(InputSymbol inputSymbol) {
        this.calculatorModel.onClickDigitButton(inputSymbol);
        updateResultTextView();
    }

    private void onDeleteButtonClick() {
        this.calculatorModel.onClickDeleteButton();
        updateResultTextView();
    }

    private void onClearButtonClick() {
        this.calculatorModel.onClickClearButton();
        updateResultTextView();
    }

    private void onOperationButtonClick(InputSymbol inputSymbol) {
        this.calculatorModel.onClickOperationButton(inputSymbol);
        updateResultTextView();
    }

    private void updateResultTextView() {
        List<InputSymbol> inputSymbolList = calculatorModel.getInput();
        calculationResultTextView.setText(convertInputSymbolsToString(inputSymbolList));
    }

    private String convertInputSymbolsToString(List<InputSymbol> inputSymbolList) {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case NUM_0:
                    sb.append(getResources().getString(R.string.zero_char));
                    break;
                case NUM_1:
                    sb.append(getResources().getString(R.string.one_char));
                    break;
                case NUM_2:
                    sb.append(getResources().getString(R.string.two_char));
                    break;
                case NUM_3:
                    sb.append(getResources().getString(R.string.three_char));
                    break;
                case NUM_4:
                    sb.append(getResources().getString(R.string.four_char));
                    break;
                case NUM_5:
                    sb.append(getResources().getString(R.string.five_char));
                    break;
                case NUM_6:
                    sb.append(getResources().getString(R.string.six_char));;
                    break;
                case NUM_7:
                    sb.append(getResources().getString(R.string.seven_char));;
                    break;
                case NUM_8:
                    sb.append(getResources().getString(R.string.eight_char));
                    break;
                case NUM_9:
                    sb.append(getResources().getString(R.string.nine_char));
                    break;
                case DOT:
                    sb.append(getResources().getString(R.string.dot_char));
                    break;
                case MINUS:
                    sb.append(getResources().getString(R.string.minus_char));
                    break;
                case PLUS:
                    sb.append(getResources().getString(R.string.plus_char));
                    break;
                case MULTIPLICATION:
                    sb.append(getResources().getString(R.string.multiplication_char ));
                    break;
                case DIVISION:
                    sb.append(getResources().getString(R.string.division_char));
                    break;
                default:
                    sb.append(getResources().getString(R.string.default_char));
                    break;
            }
        }
        return sb.toString();
    }

    public void showResult(String result) {
        Intent intent = new Intent(this, BigTextActivity.class);
        intent.putExtra(KEY_CALC_MODEL, result);
        startActivity(intent);
    }

    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(KEY_CALC_MODEL, calculatorModel);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.calculatorModel = (CalculatorModel) savedInstanceState.getSerializable(KEY_CALC_MODEL);
        updateResultTextView();
    }
}