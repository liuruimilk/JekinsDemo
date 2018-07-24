package com.rui.jekinsdemo.translation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * create by liumingrui at 2018/7/23
 **/
public class TranslateImageView extends AppCompatImageView {

  private Matrix a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;

  public TranslateImageView(Context context) {
    super(context);
    init();
  }
  public TranslateImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }
  public TranslateImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.a = new Matrix();
  }

  private void b() {
    int j = getWidth();
    int i = getHeight();
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      float c = (float) Math.max(1.0 * j / localDrawable.getIntrinsicWidth(), 1.0 * i / localDrawable.getIntrinsicHeight());
      this.f = (localDrawable.getIntrinsicHeight() * c / 2.0F - getHeight() / 2);
      this.e = (localDrawable.getIntrinsicWidth() * c - j);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    if (getDrawable() != null) {
      this.a.reset();
      this.a.postTranslate(0.0F, this.f);
    }
    float f1 = -this.b * (this.e / this.g);
    this.a.postTranslate(f1, 0.0F);
    setImageMatrix(this.a);
    super.onDraw(canvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }

  public void setCalculateX(float paramFloat) {
    this.g = paramFloat;
  }

  public void setTranslate(float paramFloat) {
    this.b = paramFloat;
    invalidate();
  }
}
