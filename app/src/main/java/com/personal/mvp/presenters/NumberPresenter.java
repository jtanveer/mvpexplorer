package com.personal.mvp.presenters;

/**
 * Created by jtanveer on 26/11/17.
 */

public interface NumberPresenter {

    void fetchNumber();

    void onAddClicked(int number);

    void onDestroy();
}
