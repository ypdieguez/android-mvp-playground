package com.github.ypdieguez.calaveritatech.exercise.ui.fetch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.github.ypdieguez.calaveritatech.exercise.R;
import com.github.ypdieguez.calaveritatech.exercise.databinding.ActivityFetchDataBinding;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.MainActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class FetchDataActivity extends DaggerAppCompatActivity implements FetchDataContract.View {

    @Inject
    FetchDataContract.Presenter mPresenter;
    ActivityFetchDataBinding mDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_fetch_data);
        mDataBinding.buttonRetry.setOnClickListener(v -> mPresenter.fetchData());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.fetchData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public void showProgress() {
        mDataBinding.buttonRetry.setVisibility(View.GONE);
        mDataBinding.textError.setVisibility(View.GONE);
        mDataBinding.progressBar.setVisibility(View.VISIBLE);
        mDataBinding.labelUpdateMsg.setVisibility(View.VISIBLE);
    }

    @Override
    public void startMainActivity() {
        startActivity(
                new Intent(this, MainActivity.class)
                        .addFlags(
                                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                        )
        );
    }

    @Override
    public void showError(int msg) {
        mDataBinding.progressBar.setVisibility(View.GONE);
        mDataBinding.labelUpdateMsg.setVisibility(View.GONE);
        mDataBinding.textError.setText(msg);
        mDataBinding.textError.setVisibility(View.VISIBLE);
        mDataBinding.buttonRetry.setVisibility(View.VISIBLE);
    }
}