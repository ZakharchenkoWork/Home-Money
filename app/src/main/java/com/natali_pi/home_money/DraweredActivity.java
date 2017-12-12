package com.natali_pi.home_money;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.natali_pi.home_money.budget.BudgetActivity;
import com.natali_pi.home_money.family_settings.FamilySettingActivity;
import com.natali_pi.home_money.main.MainActivity;
import com.natali_pi.home_money.planned_spending.PlannedSpendingActivity;
import com.natali_pi.home_money.search.Search;
import com.natali_pi.home_money.settings.SettingActivity;
import com.natali_pi.home_money.statistic.StatisticActivity;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

/**
 * Created by Natali-Pi on 11.12.2017.
 */

public class DraweredActivity extends BaseActivity {
    @Override
    public void setupSideDrawer() {
        super.setupSideDrawer();
        final ImageView imageView = (ImageView) getDrawer().findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImageDialog.build(getPickSetup())
                        .setOnPickResult(new IPickResult() {
                            @Override
                            public void onPickResult(PickResult result) {
                                imageView.setImageBitmap(result.getBitmap());

                            }
                        }).show(DraweredActivity.this);
            }
        });

        ImageView settings = (ImageView) getDrawer().findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DraweredActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        TextView lastSpendings = (TextView) getDrawer().findViewById(R.id.last_spendings);
        lastSpendings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView plannedSpendings = (TextView) getDrawer().findViewById(R.id.planned_spendings);
        plannedSpendings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, PlannedSpendingActivity.class);
                startActivity(intent);
            }
        });

        TextView budget = (TextView) getDrawer().findViewById(R.id.budget);
        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, BudgetActivity.class);
                startActivity(intent);
            }
        });

        TextView statistics = (TextView) getDrawer().findViewById(R.id.statistics);
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, StatisticActivity.class);
                startActivity(intent);
            }
        });

        TextView familySettings = (TextView)getDrawer().findViewById(R.id.familySettings);
        familySettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, FamilySettingActivity.class);
                startActivity(intent);
            }
        });
        TextView search = (TextView) getDrawer().findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.yellow);
                Intent intent = new Intent(DraweredActivity.this, Search.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        getDrawer().closeDrawers();
    }
    @Override
    protected void onResume() {
        super.onResume();
        clearMenu();
    }
    private void clearMenu(){
        TextView lastSpendings = (TextView) getDrawer().findViewById(R.id.last_spendings);
        lastSpendings.setBackgroundResource(R.color.white);
        TextView search = (TextView) getDrawer().findViewById(R.id.search);
        search.setBackgroundResource(R.color.white);
        TextView plannedSpendings = (TextView) getDrawer().findViewById(R.id.planned_spendings);
        plannedSpendings.setBackgroundResource(R.color.white);
        TextView budget = (TextView) getDrawer().findViewById(R.id.budget);
        budget.setBackgroundResource(R.color.white);
        TextView statistics = (TextView) getDrawer().findViewById(R.id.statistics);
        statistics.setBackgroundResource(R.color.white);
        TextView familySettings = (TextView) getDrawer().findViewById(R.id.familySettings);
        familySettings.setBackgroundResource(R.color.white);
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
}
