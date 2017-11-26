package com.personal.mvp.views;

import java.util.List;

/**
 * Created by jtanveer on 26/11/17.
 */

public interface NumberView {

    void setProgressIndicator(boolean show);

    void setNumbers(List<Integer> numbers);

    void showMessage(String message);
}
