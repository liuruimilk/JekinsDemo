package com.rui.jekinsdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * create by liumingrui at 2018/7/23
 **/
public class ScreenUtils {

  /**
   * Return the width of screen, in pixel.
   *
   * @return the width of screen, in pixel
   */
  public static int getScreenWidth() {
    WindowManager wm = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
    if (wm == null) {
      return App.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
    Point point = new Point();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      wm.getDefaultDisplay().getRealSize(point);
    } else {
      wm.getDefaultDisplay().getSize(point);
    }
    return point.x;
  }


  public static void NavigationBarStatusBar(Activity activity){
    if (Build.VERSION.SDK_INT >= 19) {
      View decorView = activity.getWindow().getDecorView();
      decorView.setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    if (Build.VERSION.SDK_INT >= 21) {
      View decorView = activity.getWindow().getDecorView();
      int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
      decorView.setSystemUiVisibility(option);
      activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
      activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
  }
}
