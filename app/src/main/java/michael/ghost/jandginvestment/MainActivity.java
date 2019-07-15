package michael.ghost.jandginvestment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        WebView mWebView = (WebView) findViewById(R.id.webView);

        mWebView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        super.onCreate(savedInstanceState);
        mWebView.canGoForward() ;
        mWebView.loadUrl("http://jg.snappydeveloper.com.ng/login");

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //Check whether the URL contains a whitelisted domain. In this example, we’re checking
            //whether the URL contains the “example.com” string//
            if(Uri.parse(url).getHost().endsWith("jg.snappydeveloper.com.ng")) {

                //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
                //will return ‘false” and the URL will be loaded inside your WebView//
                return false;
            }

            //If the URL doesn’t contain this string, then it’ll return “true.” At this point, we’ll
            //launch the user’s preferred browser, by firing off an Intent//
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;

        }
    }
}
