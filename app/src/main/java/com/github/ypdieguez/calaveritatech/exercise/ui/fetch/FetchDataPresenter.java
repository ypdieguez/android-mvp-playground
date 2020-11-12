package com.github.ypdieguez.calaveritatech.exercise.ui.fetch;

import androidx.annotation.Nullable;

import com.github.ypdieguez.calaveritatech.exercise.data.FetchDataRepository;
import com.github.ypdieguez.calaveritatech.exercise.data.Resource;
import com.github.ypdieguez.calaveritatech.exercise.util.ErrorMessages;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public final class FetchDataPresenter implements FetchDataContract.Presenter {

    private final FetchDataRepository repository;
    private Disposable disposable;

    @Nullable
    private FetchDataContract.View view;

    @Inject
    FetchDataPresenter(FetchDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void takeView(FetchDataContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;

        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }

        this.repository.dispose();
    }

    @Override
    public void fetchData() {
        if (disposable == null || disposable.isDisposed()) {
            disposable = repository.fetchData()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(resource -> {
                        if (view != null) {
                            if (resource.getStatus() == Resource.Status.LOADING) {
                                view.showProgress();
                            } else if (resource.getStatus() == Resource.Status.SUCCESS) {
                                view.startMainActivity();
                                disposable.dispose();
                            } else {
                                view.showError(ErrorMessages.parse(resource.getMessage()));
                                disposable.dispose();
                            }
                        }
                    });
        }
    }
}
