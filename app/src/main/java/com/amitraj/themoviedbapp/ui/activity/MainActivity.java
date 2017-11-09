package com.amitraj.themoviedbapp.ui.activity;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;

import com.amitraj.themoviedbapp.R;
import com.amitraj.themoviedbapp.databinding.ActivityMainBinding;
import com.amitraj.themoviedbapp.ui.BaseActivity;
import com.amitraj.themoviedbapp.ui.fragment.FragmentMoviesList;

public class MainActivity extends BaseActivity implements FragmentManager.OnBackStackChangedListener{
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         ActivityMainBinding mActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(mActivityMainBinding.toolbar);
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        addFragment(FragmentMoviesList.newInstance(),"FragmentMoviesList-MainActivity");
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            showExitAlert();
        } else {
            super.onBackPressed();
        }
    }

    @Override public void onBackStackChanged() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    private void showExitAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        dialog.setNegativeButton("No", null);
        dialog.show();

    }

}
