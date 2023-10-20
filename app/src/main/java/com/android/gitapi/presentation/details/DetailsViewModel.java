package com.android.gitapi.presentation.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.gitapi.data.parser.DateParser;
import com.android.gitapi.data.repository.CurrentProjectRepositoryImpl;
import com.android.gitapi.domain.model.ProjectItemModel;

import javax.inject.Inject;

public class DetailsViewModel extends ViewModel {
    private final MutableLiveData<String> imageUrlEvent = new MutableLiveData<>();
    private final MutableLiveData<String> openUrlEvent = new MutableLiveData<>();
    public ProjectItemModel model;

    public MutableLiveData<String> getImageUrlEvent() {
        return imageUrlEvent;
    }

    public MutableLiveData<String> getOpenUrlEvent() {
        return openUrlEvent;
    }

    @Inject
    public DetailsViewModel() {
        getCurrentModel();
    }

    public String parseDate() {
        return DateParser.parseDateString(model.getCreatedAt());
    }

    public void onWebButtonClick() {
        openUrlEvent.setValue(model.getHtmlUrl());
    }

    private void getCurrentModel() {
        ProjectItemModel projectItemModel = CurrentProjectRepositoryImpl.getInstance().getProject();
        model = projectItemModel;
        parseImage();
    }

    private void parseImage() {
        if (model.getAvatarUrl() != null && !model.getAvatarUrl().isBlank()) {
            imageUrlEvent.setValue(model.getAvatarUrl());
        }
    }
}
