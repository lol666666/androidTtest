package com.module.playStore;

import com.android.uiautomator.core.UiObjectNotFoundException;

public interface IPlayStore {
    public void launchPlayStore();

    public void searchAndInstallAppInPlayStore(String appName) throws UiObjectNotFoundException;
    
    public void playGame(int minute);
}
