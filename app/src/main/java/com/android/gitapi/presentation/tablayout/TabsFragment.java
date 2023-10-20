package com.android.gitapi.presentation.tablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.gitapi.R;
import com.android.gitapi.databinding.FragmentTabsBinding;
import com.android.gitapi.presentation.arch.BaseFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabsFragment extends BaseFragment<FragmentTabsBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tabs;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PagerAdapter adapter = new PagerAdapter(requireActivity().getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, this::setText).attach();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        TabLayoutRepository.getInstance().getIsShowTabLayoutEvent().observe(getViewLifecycleOwner(), value -> {
            if (value) {
                showTabLayout();
                binding.viewPager.setUserInputEnabled(true);
            } else {
                hideTabLayout();
                binding.viewPager.setUserInputEnabled(false);
            }
        });
    }

    private void hideTabLayout() {
        binding.tabLayout.setVisibility(View.GONE);
    }

    private void showTabLayout() {
        binding.tabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void setObservers() {

    }

    private void setText(TabLayout.Tab tab, int position) {
        if (position == 0) tab.setText(R.string.repositories);
        else tab.setText(R.string.favourites);
    }
}