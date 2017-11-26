package com.personal.mvp.interactors;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jtanveer on 26/11/17.
 */

public class NumberInteractoImpl implements NumberInteractor {

    private List<Integer> numbers = new ArrayList<>();

    public NumberInteractoImpl() {
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Override
    public void addNumber(int number, OnNumbersCRUDListner listner) {
        numbers.add(number);
        listner.onNumberAdded();
    }

    @Override
    public void fetchNumbers(final OnNumbersCRUDListner listner) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listner.onNumbersLoaded(getNumbers());
            }
        }, 2000);
    }

    private List<Integer> getNumbers() {
        return numbers;
    }
}
