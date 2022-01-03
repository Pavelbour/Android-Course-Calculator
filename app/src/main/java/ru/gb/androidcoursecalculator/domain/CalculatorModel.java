package ru.gb.androidcoursecalculator.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.gb.androidcoursecalculator.R;
import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;
import ru.gb.androidcoursecalculator.domain.states.BaseState;
import ru.gb.androidcoursecalculator.domain.states.SignState;

public class CalculatorModel implements Serializable {
    private LinkedList<BaseState> statesCash;
    private BaseState currentState;
    static final String TAG = "@@@";
    private float operand1;
    private float operand2;
    private InputSymbol operator;

    public CalculatorModel() {
        this.currentState = new SignState();
        this.statesCash = new LinkedList<BaseState>();
        this.statesCash.addLast(this.currentState);
    }

    public void onClickDigitButton(InputSymbol inputSymbol) {
        BaseState newState = currentState.onClickButton(inputSymbol);
        Log.d(TAG, "Old state = " + currentState.getClass().getSimpleName());
        Log.d(TAG, "Input symbol =  " + inputSymbol.name());
        Log.d(TAG, "New state = " + newState.getClass().getSimpleName());
        Log.d(TAG, "\n");
        currentState = newState;
        statesCash.addLast(newState);
    }

    public void onClickDeleteButton() {
        if (this.statesCash.size() <= 1) return;
        Log.d(TAG, "Old state = " + currentState.getClass().getSimpleName());
        currentState.deleteLastCharacter();
        statesCash.pollLast();
        BaseState newState = statesCash.getLast();
        Log.d(TAG, "New state = " + newState.getClass().getSimpleName());
        Log.d(TAG, "\n");
        currentState = newState;
    }

    public void onClickClearButton() {
        this.currentState = new SignState();
        this.statesCash.clear();
        this.statesCash.addLast(this.currentState);
        Log.d(TAG, "Input cleared.");
        Log.d(TAG, "\n");
    }

    public void onClickOperationButton(InputSymbol inputSymbol) {
        if (inputSymbol == InputSymbol.MINUS && currentState instanceof SignState) {
            onClickDigitButton(inputSymbol);
            return;
        }

        operand1 = inputToFloat();
        operator = inputSymbol;
        onClickClearButton();
    }

    public String getResult() {
        operand2 = inputToFloat();

        switch (operator) {
            case MULTIPLICATION:
                return String.valueOf(operand1 * operand2);
            case DIVISION:
                return String.valueOf(operand1 / operand2);
            case PLUS:
                return String.valueOf(operand1 + operand2);
            case MINUS:
                return String.valueOf(operand1 - operand2);
            default:
                return "error";
        }
    }

    public List<InputSymbol> getInput() {
        return new ArrayList<>(currentState.getInput());
    }

    private float inputToFloat() {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : currentState.getInput()) {
            switch (inputSymbol) {
                case NUM_0:
                    sb.append("0");
                    break;
                case NUM_1:
                    sb.append("1");
                    break;
                case NUM_2:
                    sb.append("2");
                    break;
                case NUM_3:
                    sb.append("3");
                    break;
                case NUM_4:
                    sb.append("4");
                    break;
                case NUM_5:
                    sb.append("5");
                    break;
                case NUM_6:
                    sb.append("6");
                    ;
                    break;
                case NUM_7:
                    sb.append("7");
                    ;
                    break;
                case NUM_8:
                    sb.append("8");
                    break;
                case NUM_9:
                    sb.append("9");
                    break;
                case DOT:
                    sb.append(".");
                    break;
                case MINUS:
                    sb.append("-");
                    break;
                default:
                    sb.append("@");
                    break;
            }
        }
        return Float.parseFloat(sb.toString());
    }
}
