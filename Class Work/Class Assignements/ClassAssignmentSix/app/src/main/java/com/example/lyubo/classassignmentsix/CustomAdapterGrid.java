package com.example.lyubo.classassignmentsix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lyubo on 12/4/2014.
 */
public class CustomAdapterGrid extends BaseAdapter {
    private ArrayList<Country> countryList;
    private Context context;

    public CustomAdapterGrid(Context context, ArrayList<Country> countries) {
        this.context = context;
        countryList = countries;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Country getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return countryList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView countryFlag;
        TextView countryCode;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.countrygrid, parent, false);
            countryCode = (TextView) convertView.findViewById(R.id.codeGrid);
            countryFlag = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(R.id.imageView, countryFlag);
            convertView.setTag(R.id.codeGrid, countryCode);

        } else {
            countryFlag = (ImageView) convertView.getTag(R.id.imageView);
            countryCode = (TextView) convertView.getTag(R.id.codeGrid);
        }
        countryFlag.setBackgroundResource(getItem(position).getId());
        countryCode.setText(getItem(position).getCode());
        return convertView;
    }

}
