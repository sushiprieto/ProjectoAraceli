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
public class VeganisimoFragment extends Fragment {

    private WebView webVeganisimo;

    public VeganisimoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_veganisimo, container, false);

        webVeganisimo = (WebView)v.findViewById(R.id.webVeganisimo);

        WebSettings webSettings = webVeganisimo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webVeganisimo.loadUrl("http://veganisimo.org/");

        webVeganisimo.setWebViewClient(new WebViewClient());

        webVeganisimo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    if ((keyCode == android.view.KeyEvent.KEYCODE_BACK)) {
                        if(webVeganisimo!=null) {
                            if(webVeganisimo.canGoBack()) {

                                webVeganisimo.goBack();

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
