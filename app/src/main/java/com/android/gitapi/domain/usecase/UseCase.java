package com.android.gitapi.domain.usecase;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public abstract class UseCase<OUT, IN> {

    protected abstract Single<OUT> buildUseCaseSingle(IN params);

    public Single<OUT> execute(IN params) {
        return buildUseCaseSingle(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
