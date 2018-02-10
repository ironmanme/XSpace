package com.uniFun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.uniFun.module.TemplateModule;
import com.uniFun.utils.DisplayUtil;


@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity
{
    protected Context context;

    protected TemplateModule module;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.context = this;
        DisplayUtil.setStatusBarColor(this, getResources().getColor(R.color.colorAccent));
        module = (TemplateModule) getIntent().getSerializableExtra("module");
    }

    protected void show(String gson)
    {
    }

    protected void showEmpty()
    {
    }
}
