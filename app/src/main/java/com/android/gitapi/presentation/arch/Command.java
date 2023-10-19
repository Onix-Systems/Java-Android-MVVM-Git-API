package com.android.gitapi.presentation.arch;

import androidx.navigation.NavDirections;

public abstract class Command {
    private Command() {
    }

    public static final class Back extends Command {
        private Back() {}

        public static final Back INSTANCE = new Back();
    }

    public static final class Route extends Command {
        private final NavDirections navDirections;

        public Route(NavDirections navDirections) {
            this.navDirections = navDirections;
        }

        public NavDirections getNavDirections() {
            return navDirections;
        }
    }

    public static final class ActionRoute extends Command {
        private final int action;

        public ActionRoute(int action) {
            this.action = action;
        }

        public int getAction() {
            return action;
        }
    }
}
