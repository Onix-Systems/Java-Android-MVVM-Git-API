package com.android.gitapi.presentation.arch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.android.gitapi.R;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    protected T binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment.getNavController();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        setObservers();
    }

    protected void navigate(Command command) {
        try {
            if (command instanceof Command.Route) {
                navController.navigate(((Command.Route) command).getNavDirections());
            } else if (command instanceof Command.ActionRoute) {
                navController.navigate(((Command.ActionRoute) command).getAction());
            } else if (command instanceof Command.Back) {
                navController.popBackStack();
            }
        } catch (Throwable e) {
            Log.d("NavigationError", e.toString());
        }
    }

    protected void navigate(Command command, Bundle bundle) {
        try {
            if (command instanceof Command.Route) {
                navController.navigate(((Command.Route) command).getNavDirections());
            } else if (command instanceof Command.ActionRoute) {
                navController.navigate(((Command.ActionRoute) command).getAction(), bundle);
            } else if (command instanceof Command.Back) {
                navController.popBackStack();
            }
        } catch (Throwable e) {
            Log.d("NavigationError", e.toString());
        }
    }


    protected abstract int getLayoutId();

    protected abstract void setupViews();

    protected abstract void setObservers();
}
