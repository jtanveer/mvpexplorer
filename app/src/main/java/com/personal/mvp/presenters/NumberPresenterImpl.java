package com.personal.mvp.presenters;

import com.personal.mvp.interactors.NumberInteractor;
import com.personal.mvp.views.NumberView;

import java.util.List;

/**
 * Created by jtanveer on 26/11/17.
 */

public class NumberPresenterImpl implements NumberPresenter, NumberInteractor.OnNumbersCRUDListner {

    private NumberInteractor numberInteractor;
    private NumberView numberView;

    public NumberPresenterImpl(NumberInteractor numberInteractor, NumberView numberView) {
        this.numberInteractor = numberInteractor;
        this.numberView = numberView;
    }

    @Override
    public void fetchNumber() {
        numberView.setProgressIndicator(true);
        numberView.showMessage("Fething numbers..");
        numberInteractor.fetchNumbers(this);
    }

    @Override
    public void onAddClicked(int number) {
        numberInteractor.addNumber(number, this);
        numberView.showMessage("Adding more number..");
    }

    @Override
    public void onDestroy() {
        numberView = null;
    }

    @Override
    public void onNumbersLoaded(List<Integer> numbers) {
        numberView.setNumbers(numbers);
        numberView.setProgressIndicator(false);
    }

    @Override
    public void onNumberAdded() {
        numberView.setProgressIndicator(true);
        numberInteractor.fetchNumbers(this);
    }
}
