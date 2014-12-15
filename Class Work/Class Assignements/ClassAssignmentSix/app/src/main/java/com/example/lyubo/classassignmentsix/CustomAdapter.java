package com.example.lyubo.classassignmentsix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lyubo on 12/4/2014.
 */
public class CustomAdapter extends BaseAdapter {
    private String[] countriesLs = new String[]{"Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France"};
    private String[] codes = new String[]{"AUS", "BEL", "BG", "CRO", "CYP",
            "CZ", "DEN", "EST", "FIN", "FR"};
    private ArrayList<Country> countryList = new ArrayList<Country>();
    private Context context;
    private Country country = new Country();

    public CustomAdapter(Context context) {
        this.context = context;
        populateCountries();
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

        TextView countryName;
        TextView countryCode;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.country, parent, false);
            countryName = (TextView) convertView.findViewById(R.id.name);
            countryCode = (TextView) convertView.findViewById(R.id.code);
            convertView.setTag(R.id.name, countryName);
            convertView.setTag(R.id.code, countryCode);

        } else {
            countryName = (TextView) convertView.getTag(R.id.name);
            countryCode = (TextView) convertView.getTag(R.id.code);
        }
        countryName.setText(getItem(position).getName());
        countryCode.setText(getItem(position).getCode());
        return convertView;
    }

    private void populateCountries() {
        for (int i = 0; i < countriesLs.length; i++) {
            Country cnt = new Country(countriesLs[i], codes[i]);
            countryList.add(cnt);
        }
    }

    public ArrayList<Country> getSportList() {
        return countryList;
    }
}
