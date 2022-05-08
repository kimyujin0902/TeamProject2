package com.android.teamproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeekFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DATE = "date";
    private static int myear, mmonth, mdate;

    // TODO: Rename and change types of parameters

    public WeekFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WeekFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeekFragment newInstance(int y, int m, int d) {
        WeekFragment fragment = new WeekFragment();
        myear = y;
        mmonth = m;
        mdate = d;
        Bundle args = new Bundle();
        args.putInt(YEAR, y);
        args.putInt(MONTH, m);
        args.putInt(DATE, d);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myear = getArguments().getInt(YEAR);
            mmonth = getArguments().getInt(MONTH);
            mdate = getArguments().getInt(DATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_month, container, false);
        ListView listView = (ListView) rootview.findViewById(R.id.weekDate);
        Calendar calendar = Calendar.getInstance();
        calendar.set(myear, mmonth, mdate);
        int startDate = mdate-(calendar.getFirstDayOfWeek()-2);
        String[] dates = new String[7];
        for(int i=0; i<startDate+7;i++)
            dates[i] = ""+startDate+1;
        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dates);
        listView.setAdapter(adapt);
        return inflater.inflate(R.layout.fragment_week, container, false);
    }
}