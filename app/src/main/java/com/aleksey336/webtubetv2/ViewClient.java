package com.aleksey336.webtubetv2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        String url = request.getUrl().toString();
        view.loadUrl(url);
        return true;
    }

//    @Override
//    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
//        // Handle key events here
//        return super.shouldOverrideKeyEvent(view, event);
//    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        view.evaluateJavascript("const clear = (() => {\n" +
                "    const defined = v => v !== null && v !== undefined;\n" +
                "    const timeout = setInterval(() => {\n" +
                "        const ad = [...document.querySelectorAll('.ad-showing')][0];\n" +
                "        if (defined(ad)) {\n" +
                "            const video = document.querySelector('video');\n" +
                "            if (defined(video)) {\n" +
                "                video.currentTime = video.duration;\n" +
                "            }\n" +
                "        }\n" +
                "    }, 500);\n" +
                "    return function() {\n" +
                "        clearTimeout(timeout);\n" +
                "    }\n" +
                "})();", null);

    }
}
