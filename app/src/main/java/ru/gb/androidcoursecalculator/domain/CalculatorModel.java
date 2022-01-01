package ru.gb.androidcoursecalculator.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;
import ru.gb.androidcoursecalculator.domain.states.BaseState;
import ru.gb.androidcoursecalculator.domain.states.SignState;

public class CalculatorModel {
    private LinkedList<BaseState> statesCash;
    private BaseState currentState;
    static final String TAG = "@@@";

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

    public List<InputSymbol> getInput() {
        return new ArrayList<>(currentState.getInput());
    }
}
