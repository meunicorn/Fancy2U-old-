package com.meunicorn.fancy2u.UI.Activivty

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.jakewharton.scalpel.ScalpelFrameLayout
import com.meunicorn.fancy2u.Bean.Shots.Shot
import com.meunicorn.fancy2u.R
import com.meunicorn.fancy2u.UI.Adapter.ShotFragmentViewPagerAdapter
import com.meunicorn.fancy2u.UI.Fragment.DummyFragment
import com.meunicorn.fancy2u.UI.Fragment.ShotFragment
import com.meunicorn.fancy2u.UI.Fragment.dummy.DummyContent
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, DummyFragment.OnFragmentInteractionListener, ShotFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: Shot) {
        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentInteraction(uri: Uri?) {
        throw UnsupportedOperationException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainView=layoutInflater.inflate(R.layout.activity_main,null)
        val mScalpeView:ScalpelFrameLayout= ScalpelFrameLayout(this)
        mScalpeView.addView(mainView)
        mScalpeView.isLayerInteractionEnabled=true
        mScalpeView.chromeColor = Color.parseColor("#34B9E4")
        setContentView(mScalpeView)
//        setContentView
        mScalpeView.setDrawViews(true)


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        initViewPager()

    }

    private fun initViewPager() {
        val adapter: ShotFragmentViewPagerAdapter = ShotFragmentViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ShotFragment.newInstance("popluarity"), resources.getString(R.string.popular))
        adapter.addFragment(ShotFragment.newInstance("recent"), resources.getString(R.string.recent))
        adapter.addFragment(ShotFragment.newInstance("comments"),resources.getString(R.string.comments))
        adapter.addFragment(ShotFragment.newInstance("views"),resources.getString(R.string.views))
        vp_main_display.adapter = adapter
        tab_main_title.setupWithViewPager(vp_main_display)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    @SuppressWarnings("StatementWithEmptyBody")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_mainpage) {
            // Handle the camera action
        } else if (id == R.id.nav_buckets) {

        } else if (id == R.id.nav_follwers) {

        } else if (id == R.id.nav_likes) {

        } else if (id == R.id.nav_projects) {

        } else if (id == R.id.nav_shots) {

        }else if (id == R.id.nav_teams) {

        }else if (id == R.id.nav_about) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
