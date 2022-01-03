package ru.gb.androidcoursecalculator.domain.states;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.gb.androidcoursecalculator.domain.entities.InputSymbol;

public class IntState extends BaseState implements Serializable {

    public IntState(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case NUM_0:
            case NUM_1:
            case NUM_2:
            case NUM_3:
            case NUM_4:
            case NUM_5:
            case NUM_6:
            case NUM_7:
            case NUM_8:
            case NUM_9:
                input.add(inputSymbol);
                return this;
            case DOT:
                List<InputSymbol> newInput = new ArrayList<>(input);
                newInput.add(InputSymbol.DOT);
                return new FloatState(newInput);
            default:
                return this;
        }
    }
}
