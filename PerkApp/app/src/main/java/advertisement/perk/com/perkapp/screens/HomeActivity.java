package advertisement.perk.com.perkapp.screens;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import advertisement.perk.com.perkapp.R;
import advertisement.perk.com.perkapp.screens.fragments.AdsListFragment;
import advertisement.perk.com.perkapp.screens.fragments.ContactUsFragment;
import advertisement.perk.com.perkapp.screens.fragments.HistoryFragment;
import advertisement.perk.com.perkapp.screens.fragments.PerkPointsFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String NAV_ITEM_ID = "navItemId";
    private int mNavItemId;

    private AdsListFragment mAdsListFragment = new AdsListFragment();
    private PerkPointsFragment mPerkPointsFragment = new PerkPointsFragment();
    private HistoryFragment mHistoryListFragment = new HistoryFragment();
    private ContactUsFragment mContactUsFragment = new ContactUsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null == savedInstanceState) {
            mNavItemId = R.id.nav_advertise;
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mAdsListFragment)
                .commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //        // select the correct nav menu item
        navigationView.getMenu().findItem(mNavItemId).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_advertise) {
            // Handle the camera action
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, mAdsListFragment)
                    .commit();
        } else if (id == R.id.nav_perkPoints) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, mPerkPointsFragment)
                    .commit();
        } else if (id == R.id.nav_contactUs) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, mContactUsFragment)
                    .commit();
        } else if (id == R.id.nav_history) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, mHistoryListFragment)
                    .commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
