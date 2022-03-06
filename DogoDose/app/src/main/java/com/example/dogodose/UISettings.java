package com.example.dogodose;

import android.view.View;
import java.util.Objects;

public class UISettings {

    private final View mDecorView;

    public UISettings(MainActivity main){
        try
        {
            Objects.requireNonNull(main.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}
        mDecorView = main.getWindow().getDecorView();
        hideUI();
    }

    public void hideUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
}
