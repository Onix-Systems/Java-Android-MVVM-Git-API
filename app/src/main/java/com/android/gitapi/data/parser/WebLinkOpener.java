package com.android.gitapi.data.parser;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.android.gitapi.R;
import com.google.android.material.snackbar.Snackbar;

public class WebLinkOpener {

    public static void openLinkInBrowser(String url, View view) {
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
            view.getContext().startActivity(intent);
        } else {
            Snackbar.make(view, view.getContext().getString(R.string.error_when_opening_a_web_page), 2000).show();
        }
    }
}
