package ru.gb.androidcoursecalculator.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;

abstract public class BaseState {
    protected final List<InputSymbol> input = new ArrayList<>();

    public abstract BaseState onClickButton(InputSymbol inputSymbol);

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }
}
