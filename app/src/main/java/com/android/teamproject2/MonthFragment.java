package com.android.teamproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.Calendar;

public class MonthFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static int myear, mmonth;


    // TODO: Rename and change types of parameters
//    int myear;
//    int mmonth;

    public MonthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ThisMonthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthFragment newInstance(int y, int m) {
        MonthFragment fragment = new MonthFragment();
        myear = y;
        mmonth = m;
        Bundle args = new Bundle();
        args.putInt(YEAR, y);
        args.putInt(MONTH, m);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myear = getArguments().getInt(YEAR);
            mmonth = getArguments().getInt(MONTH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_month, container, false);

        Calendar calendar = Calendar.getInstance();
        calendar.set(myear, mmonth,1);

        int lastday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startday = calendar.get(calendar.DAY_OF_WEEK);
        int daySize = lastday + startday - 1;

        String[] days = new String[daySize];
        for(int i=0; i<startday; i++)
            days[i] = "";

        for(int i=startday-1; i<daySize; i++)
            days[i] = "" + (i - startday + 2);

        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                days);

        GridView gridview = (GridView) rootview.findViewById(R.id.gridview);
        gridview.setAdapter(adapt);
        return rootview;
    }
}