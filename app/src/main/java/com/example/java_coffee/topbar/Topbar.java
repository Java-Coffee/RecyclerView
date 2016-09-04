package com.example.java_coffee.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Java-Coffee on 2016/9/4.
 */
public class Topbar extends RelativeLayout{

    private Button leftButton,rightButton;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams,rightParams,titleParams;

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //TypedArray中包含了所有attrs中值的属性和映射
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Topbar);
        leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = ta.getString(R.styleable.Topbar_leftText);

        rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = ta.getString(R.styleable.Topbar_rightText);

        titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor,0);
        title = ta.getString(R.styleable.Topbar_title);

        ta.recycle();//回收ta，避免浪费资源以及缓存引起的错误
        
        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);
        
        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setText(title);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        
        addView(leftButton,leftParams);
        addView(rightButton,rightParams);
        addView(tvTitle,titleParams);
        
        
    }
}
