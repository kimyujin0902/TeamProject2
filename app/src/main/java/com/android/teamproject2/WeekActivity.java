package com.android.teamproject2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class WeekActivity extends AppCompatActivity {
    int year, month, date;
    int isWeek = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        Intent getIntent = getIntent();
        month = getIntent.getIntExtra("monthInfo", 0);
        year = getIntent.getIntExtra("yearInfo", 0);
        date = getIntent.getIntExtra("datdInfo", 7);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(year+"년"+(month+1)+"월");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_monthCal:
                if(isWeek != 0) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("yearInfo", year);
                    intent.putExtra("monthInfo", month);
                    startActivity(new Intent(this,MainActivity.class));
                    finish();
                }
                return true;
            case R.id.action_weekCal:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}