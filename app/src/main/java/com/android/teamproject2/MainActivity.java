package com.android.teamproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Calendar;
/**은희야 있니? 보이니? 지금은 되니? Week...**/
public class MainActivity extends AppCompatActivity {
    int isMonth = 1;
    int year, month, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        ViewPager2 vpPager = findViewById(R.id.vpPager);
        FragmentStateAdapter adapter = null;
        if(isMonth==1){ adapter = new MonthPagerAdapter(this, year, month); }
        else { Log.i("hey", "else");} //adapter = new WeekPagerAdapter(this); }
        vpPager.setAdapter(adapter);

        vpPager.setCurrentItem(1);
        vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_monthCal:
                if(isMonth != 1){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("isMonth", 1);
                    startActivity(intent);
                    finish();
                };
                startActivity(new Intent(this,MainActivity.class));
                return true;
            case R.id.action_weekCal:
                if(isMonth != 0) {
                    Intent intent = new Intent(getApplicationContext(), WeekActivity.class);
                    intent.putExtra("yearInfo", year);
                    intent.putExtra("monthInfo", month);
                    intent.putExtra("dateInfo", date);
                    startActivity(intent);
                    finish();
                };
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}