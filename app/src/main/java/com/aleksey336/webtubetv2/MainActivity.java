package com.aleksey336.webtubetv2;

import android.app.Instrumentation;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;


public class MainActivity extends FragmentActivity {

    WebView wv;

    @Override
    public void onBackPressed() {
        wv.evaluateJavascript("function triggerEscape() {\n" +
                "  const event = new KeyboardEvent('keydown', {\n" +
                "    key: 'Escape',\n" +
                "    code: 'Escape',\n" +
                "    keyCode: 27,\n" +
                "    which: 27,\n" +
                "    bubbles: true\n" +
                "  });\n" +
                "  document.dispatchEvent(event);\n" +
                "}\n" +
                "\n" +
                "triggerEscape();", null);
        
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = findViewById(R.id.webview);

//        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
//            public void handleOnBackPressed() {
//
//            }});


        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUserAgentString("Mozilla/5.0 (PS4; Leanback Shell) Gecko/20100101 Firefox/65.0 LeanbackShell/01.00.01.75 Sony PS4/ (PS4, , no, CH)");
        wv.setWebViewClient(new ViewClient());
        wv.loadUrl("https://youtube.com/tv#/?env_forceFullAnimation=true");
    }
}