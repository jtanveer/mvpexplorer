package com.personal.mvp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.personal.mvp.R;
import com.personal.mvp.adapters.NumberAdapter;
import com.personal.mvp.databinding.ActivityMainBinding;
import com.personal.mvp.interactors.NumberInteractoImpl;
import com.personal.mvp.presenters.NumberPresenter;
import com.personal.mvp.presenters.NumberPresenterImpl;
import com.personal.mvp.views.NumberView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NumberView, View.OnClickListener {

    private ActivityMainBinding mBinding;
    private NumberPresenter mPresenter;

    private List<Integer> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.fab.setOnClickListener(this);

        mBinding.rvNumbers.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.setData(data);
        mBinding.rvNumbers.setAdapter(new NumberAdapter(data));

        // this needs to be injected using Dagger 2
        mPresenter = new NumberPresenterImpl(new NumberInteractoImpl(), this);
        mPresenter.fetchNumber();
    }

    @Override
    public void setProgressIndicator(boolean show) {
        if (show)
            mBinding.progress.setVisibility(View.VISIBLE);
        else
            mBinding.progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setNumbers(List<Integer> numbers) {
        data.clear();
        data.addAll(numbers);
        mBinding.rvNumbers.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(mBinding.fab, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        mPresenter.onAddClicked(data.size() + 1);
    }
}
