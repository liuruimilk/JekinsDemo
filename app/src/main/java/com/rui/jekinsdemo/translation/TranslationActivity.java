package com.rui.jekinsdemo.translation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.HorizontalScrollView;

import com.rui.jekinsdemo.R;
import com.rui.jekinsdemo.ScreenUtils;

public class TranslationActivity extends AppCompatActivity {


  private HorizontalScrollView hsv;
  private TranslateImageView iv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_translation);
    iv = findViewById(R.id.iv);
    hsv = findViewById(R.id.hsv);

    iv.setImageResource(R.drawable.roadmap_bg_0);
    ScreenUtils.NavigationBarStatusBar(this);

    new Handler().post(() -> {
      hsv.measure(0,0);
      int measuredWidth = hsv.getMeasuredWidth();
      iv.setCalculateX(measuredWidth);

    });

    hsv.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
      Log.d("test", "scrollX : " + scrollX);
      iv.setTranslate(scrollX);
    });
  }

}
