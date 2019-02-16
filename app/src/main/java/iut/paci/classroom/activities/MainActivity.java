package iut.paci.classroom.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import iut.paci.classroom.R;
import iut.paci.classroom.fragments.FragmentAboutus;
import iut.paci.classroom.fragments.FragmentLogout;
import iut.paci.classroom.fragments.FragmentQrcode;
import iut.paci.classroom.fragments.FragmentQuiz;
import iut.paci.classroom.fragments.FragmentSettings;
import iut.paci.classroom.fragments.FriendsFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //fragment actif au demarrage
        //maintenir l'etat du fragment à la rotation
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FriendsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_amis);
        }


    }
@Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
}


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_amis:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FriendsFragment()).commit();
                break;

            case R.id.nav_quiz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentQuiz()).commit();
                break;

            case R.id.nav_presence:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentQrcode()).commit();
                break;

            case R.id.nav_settings:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentSettings()).commit();
                Intent i=new Intent(this,SettingsActivity.class);
                startActivity(i);
                break;

            case R.id.nav_apropos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentAboutus()).commit();
                break;

            case R.id.nav_logout:
                Intent in=new Intent(this,LoginActivity.class);
                startActivity(in);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentLogout()).commit();
                break;

            case R.id.nav_share:
                shareTextUrl();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Share this app on social media");
        share.putExtra(Intent.EXTRA_TEXT, "Download classroom app here " + " http://www.classroom.com");

        startActivity(Intent.createChooser(share, "Share link!"));
    }


}
