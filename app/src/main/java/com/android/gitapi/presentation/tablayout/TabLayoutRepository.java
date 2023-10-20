package com.android.gitapi.presentation.tablayout;

import androidx.lifecycle.MutableLiveData;

public class TabLayoutRepository {

    private MutableLiveData<Boolean> isShowTabLayoutEvent = new MutableLiveData<>();

    private static TabLayoutRepository instance;

    private TabLayoutRepository() {

    }

    public MutableLiveData<Boolean> getIsShowTabLayoutEvent() {
        return isShowTabLayoutEvent;
    }

    public void setIsShowTabLayoutEvent(Boolean isShow) {
        isShowTabLayoutEvent.setValue(isShow);
    }

    public static TabLayoutRepository getInstance() {
        if (instance == null) {
            instance = new TabLayoutRepository();
        }
        return instance;
    }

}
