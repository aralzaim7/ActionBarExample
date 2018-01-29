package com.ab2018.actionbarexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    WebView webView;
    EditText search;
    Button searchBtn;

    public final static String url = "https://www.google.com.tr/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        webView = (WebView) findViewById(R.id.webView);
        search = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGoogle(search.getText().toString());
            }
        });

    }

    public void goToGoogle(String keyword)
    {
        String URL = url + keyword;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URL);

        final ProgressDialog progressDialog = ProgressDialog.show(this, "Arama", "Yükleniyor", true);
        progressDialog.show();

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressDialog.dismiss();
            }
        });

    }
}
