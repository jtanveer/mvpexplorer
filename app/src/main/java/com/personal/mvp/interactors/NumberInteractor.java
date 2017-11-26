package com.personal.mvp.interactors;

import java.util.List;

/**
 * Created by jtanveer on 26/11/17.
 */

public interface NumberInteractor {

    interface OnNumbersCRUDListner {
        void onNumbersLoaded(List<Integer> numbers);

        void onNumberAdded();
    }

    void addNumber(int number, OnNumbersCRUDListner listner);

    void fetchNumbers(OnNumbersCRUDListner listner);
}
