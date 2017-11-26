package com.personal.mvp.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.personal.mvp.BR;
import com.personal.mvp.R;

import java.util.List;

/**
 * Created by jtanveer on 1/9/17.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.BindingViewHolder> {

    private List<Integer> numbers;

    public NumberAdapter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false);
        return new BindingViewHolder(item);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.number, numbers.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

    }
}
