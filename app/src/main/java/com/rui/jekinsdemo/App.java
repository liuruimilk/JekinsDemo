package com.rui.jekinsdemo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * create by liumingrui at 2018/7/20
 **/
public class App extends Application {

  private static App app;
  @Override
  public void onCreate() {
    super.onCreate();
    app = this;
    Fabric.with(this, new Crashlytics());
  }

  public static App getInstance() {
    return app;
  }
}
