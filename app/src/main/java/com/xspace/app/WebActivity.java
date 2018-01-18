package com.xspace.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import demo.pplive.com.xspace.R;

public class WebActivity extends BaseActivity
{
    private WebView webView;

    private ImageView back;

    private ImageView refresh;

    private TextView title;

    private ProgressBar loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
        refresh = findViewById(R.id.refresh);
        loading = findViewById(R.id.loading);
        title = findViewById(R.id.title_txt);

        refresh.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                webView.reload();
            }
        });

        loading.setVisibility(View.VISIBLE);
        webView = findViewById(R.id.web_view);
        if (module == null || module.url == null || "".equals(module.url))
        {
            return;
        }
        title.setText(module.url);
        title.setSingleLine(true);
        webView.loadUrl(module.url);
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress)
            {

                if (newProgress == 100)
                {
                    loading.setVisibility(View.GONE);
                }
                else
                {
                    loading.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (webView.canGoBack())
            {
                webView.goBack();
                return true;
            }
            else
            {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void show(String gson)
    {
        super.show(gson);
    }

    @Override
    protected void showEmpty()
    {
        super.showEmpty();
    }
}
