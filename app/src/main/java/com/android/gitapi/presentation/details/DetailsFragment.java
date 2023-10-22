package com.android.gitapi.presentation.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.android.gitapi.App;
import com.android.gitapi.R;
import com.android.gitapi.data.parser.WebLinkOpener;
import com.android.gitapi.databinding.FragmentDetailsBinding;
import com.android.gitapi.presentation.arch.BaseFragment;
import com.android.gitapi.presentation.arch.Command;
import com.android.gitapi.presentation.tablayout.TabLayoutRepository;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class DetailsFragment extends BaseFragment<FragmentDetailsBinding> {

    @Inject
    DetailsViewModelFactory viewModelFactory;


    private DetailsViewModel viewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(DetailsViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getImageUrlEvent().observe(getViewLifecycleOwner(), this::uploadImage);
        viewModel.getOpenUrlEvent().observe(getViewLifecycleOwner(), this::openWebPage);
        binding.ivBack.setOnClickListener(v -> {
            navigate(new Command.Back());
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        TabLayoutRepository.getInstance().setIsShowTabLayoutEvent(false);
    }

    private void uploadImage(String url) {
        Glide.with(binding.getRoot())
                .load(url)
                .placeholder(R.drawable.default_user_image)
                .into(binding.ownerAvatarImageView);
    }

    private void openWebPage(String webLink) {
        WebLinkOpener.openLinkInBrowser(webLink, binding.getRoot());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void setObservers() {

    }
}
