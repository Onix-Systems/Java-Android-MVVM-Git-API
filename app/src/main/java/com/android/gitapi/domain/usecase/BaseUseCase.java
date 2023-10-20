package com.android.gitapi.domain.usecase;


public abstract class BaseUseCase<OUT, IN> {

    protected abstract OUT buildUseCaseSingle(IN params);

    public OUT execute(IN params) {
        return buildUseCaseSingle(params);
    }
}
