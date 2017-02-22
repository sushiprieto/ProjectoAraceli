package com.trabajo.carlos.mostrarwebpages;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.trabajo.carlos.mostrarwebpages.fragments.BeginveganbegunFragment;
import com.trabajo.carlos.mostrarwebpages.fragments.CookpadFragment;
import com.trabajo.carlos.mostrarwebpages.fragments.PrincipalFragment;
import com.trabajo.carlos.mostrarwebpages.fragments.RecetasveganasFragment;
import com.trabajo.carlos.mostrarwebpages.fragments.VeganisimoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager manager;
    FragmentTransaction transaction;

    PrincipalFragment fprincipal = new PrincipalFragment();
    BeginveganbegunFragment fbeginveganbegun = new BeginveganbegunFragment();
    RecetasveganasFragment frecetasveganas = new RecetasveganasFragment();
    VeganisimoFragment fveganisimo = new VeganisimoFragment();
    CookpadFragment fcookpad = new CookpadFragment();

    private final String tagfprincipal = "fprincipal";
    private final String tagfbeginveganbegun = "fbeginveganbegun";
    private final String tagfrecetasveganas = "frecetasveganas";
    private final String tagfveganisimo = "fveganisimo";
    private final String tagfcookpad = "fcookpad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        transaction.replace(R.id.contenedor_fragment, fprincipal, tagfprincipal);
        transaction.commit();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (id){

            case R.id.nav_beginveganbegun:

                transaction.replace(R.id.contenedor_fragment, fbeginveganbegun, tagfbeginveganbegun);
                transaction.commit();

                break;

            case R.id.nav_recetasveganas:

                transaction.replace(R.id.contenedor_fragment, frecetasveganas, tagfrecetasveganas);
                transaction.commit();

                break;

            case R.id.nav_veganisimo:

                transaction.replace(R.id.contenedor_fragment, fveganisimo, tagfveganisimo);
                transaction.commit();

                break;

            case R.id.nav_cookpad:

                transaction.replace(R.id.contenedor_fragment, fcookpad, tagfcookpad);
                transaction.commit();

                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**@Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }**/

    /**
     * Metodo para que al presionar la tecla atras no se salga de la app y retroceda en el webview
     */


   /** @Override
    public void onBackPressed() {

        BeginveganbegunFragment fbeginveganbegun = (BeginveganbegunFragment)getSupportFragmentManager().findFragmentById(R.id.contenedor_fragment);
        //RecetasveganasFragment frecetasveganas = (RecetasveganasFragment)getSupportFragmentManager().findFragmentById(R.id.contenedor_fragment);

        if (fbeginveganbegun.canGoBack()) {

            fbeginveganbegun.goBack();


        } else {

            super.onBackPressed();

        }

    }**/
}
