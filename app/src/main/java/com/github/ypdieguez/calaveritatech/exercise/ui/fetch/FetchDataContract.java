package com.github.ypdieguez.calaveritatech.exercise.ui.fetch;

import com.github.ypdieguez.calaveritatech.exercise.ui.BasePresenter;
import com.github.ypdieguez.calaveritatech.exercise.ui.BaseView;

public class FetchDataContract {
    public interface View extends BaseView<Presenter> {
        void showProgress();
        void startMainActivity();
        void showError(int msg);
    }

    public interface Presenter extends BasePresenter<View> {
        void fetchData();
    }
}
