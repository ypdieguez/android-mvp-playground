package com.github.ypdieguez.calaveritatech.exercise.data;

import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.DataDao;
import com.github.ypdieguez.calaveritatech.exercise.data.remote.APIService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class FetchDataRepository {

    private final DataDao dataDao;
    private final APIService api;
    private Disposable disposable;

    @Inject
    FetchDataRepository(DataDao dataDao, APIService api) {
        this.dataDao = dataDao;
        this.api = api;
    }

    public Observable<Resource> fetchData() {

        return Observable.create(emitter -> {
            if (disposable == null || disposable.isDisposed()) {
                emitter.onNext(Resource.loading());
                disposable = api.fetchData()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(Schedulers.io())
                        .subscribe(
                                categories -> {
                                    dataDao.updateData(categories);
                                    emitter.onNext(Resource.success());
                                },
                                throwable -> emitter.onNext(Resource.error(throwable.getMessage())),
                                emitter::onComplete
                        );
            } else {
                emitter.onComplete();
            }
        });
    }

    public void dispose() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
