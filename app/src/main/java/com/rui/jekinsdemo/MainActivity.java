package com.rui.jekinsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rui.jekinsdemo.translation.TranslationActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void roadmap(View view) {
    startActivity(new Intent(this,TranslationActivity.class));
    Log.d("2","2");
  }
}
