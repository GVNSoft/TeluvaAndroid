package com.gvn.teluva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BaseActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        setWebView();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setWebView(){
        mWebView = (WebView)findViewById(R.id.main_web_view);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(TeluvaConstants.BASE_URL);
        mWebView.getSettings().setJavaScriptEnabled(true);
        WebSettings set = mWebView.getSettings();
        set.setJavaScriptEnabled(true); // javascript를 실행할 수 있도록 설정
        set.setJavaScriptCanOpenWindowsAutomatically (true);   // javascript가 window.open()을 사용할 수 있도록 설정
        set.setPluginState(WebSettings.PluginState.ON_DEMAND); // 플러그인을 사용할 수 있도록 설정
        set.setLoadsImagesAutomatically(true); // 웹뷰가 앱에 등록되어 있는 이미지 리소스를 자동으로 로드하도록 설정
        set.setUseWideViewPort(true); // wide viewport를 사용하도록 설정
    }


}
