package com.richer.thirteenwater;

import android.app.Application;

import com.richer.thirteenwater.NetWork.Network;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Network.init();
    }
}
