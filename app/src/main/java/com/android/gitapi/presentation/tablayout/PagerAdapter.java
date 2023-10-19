package com.android.gitapi.presentation.tablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.gitapi.presentation.repositorylist.RepositoryListFragment;

public class PagerAdapter extends FragmentStateAdapter {
    private static final int NUM_TABS = 2;

    public PagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RepositoryListFragment();
            case 1:
                return new RepositoryListFragment();
        }
        throw new IllegalStateException();
    }
}
