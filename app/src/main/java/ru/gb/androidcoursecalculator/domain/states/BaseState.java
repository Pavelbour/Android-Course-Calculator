package ru.gb.androidcoursecalculator.domain.states;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;

abstract public class BaseState implements Serializable {
    protected final List<InputSymbol> input = new ArrayList<>();

    public abstract BaseState onClickButton(InputSymbol inputSymbol);

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }
    public void deleteLastCharacter() { this.input.remove(input.size() - 1); }
}
