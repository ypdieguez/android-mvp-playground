package com.github.ypdieguez.calaveritatech.exercise.ui.main;

import com.github.ypdieguez.calaveritatech.exercise.ui.BasePresenter;
import com.github.ypdieguez.calaveritatech.exercise.ui.BaseView;

public class MainContract {
    public interface View extends BaseView<Presenter> {
    }

    public interface Presenter extends BasePresenter<View> {
        void isFullLoading();
    }
}
