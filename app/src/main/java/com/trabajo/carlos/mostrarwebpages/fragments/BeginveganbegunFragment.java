package com.trabajo.carlos.mostrarwebpages.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trabajo.carlos.mostrarwebpages.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeginveganbegunFragment extends Fragment{

    private WebView webBeginveganbegun;

    public BeginveganbegunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_beginveganbegun, container, false);

        webBeginveganbegun = (WebView)v.findViewById(R.id.webBeginveganbegun);

        WebSettings webSettings = webBeginveganbegun.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webBeginveganbegun.loadUrl("http://beginveganbegun.es/");

        webBeginveganbegun.setWebViewClient(new WebViewClient());

        webBeginveganbegun.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    if ((keyCode == android.view.KeyEvent.KEYCODE_BACK)) {
                        if(webBeginveganbegun!=null) {
                            if(webBeginveganbegun.canGoBack()) {

                                webBeginveganbegun.goBack();

                            }
                        }
                    }
                }

                return true;

            }
        });

        return v;
    }



}
