package com.android.teamproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;
/**은희야 있니? 보이니? 지금은 되니?**/
public class MainActivity extends AppCompatActivity {
    boolean isMonth = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        Log.i("hey", "Calendar: "+year+", This month: "+month);
        ViewPager2 vpPager = findViewById(R.id.vpPager);
        FragmentStateAdapter adapter = null;
        if(isMonth){ adapter = new MonthPagerAdapter(this, year, month); }
        else { Log.i("hey", "else"); }//adapter = new WeekPagerAdapter(this); }
        vpPager.setAdapter(adapter);

        vpPager.setCurrentItem(1);
        vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_monthCal:
                Intent intent = new Intent(this, MonthFragment.class);
                return true;
            /**case R.id.action_weekCal:
             startActivity(new Intent(this,WeekFragment.class));
             return true;**/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}