package com.mentormate.academy.redoflags;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class Main_Activity extends ActionBarActivity {
    GridView list;
    CustomAdapterGrid adapter;
    private ArrayList<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        list = (GridView) findViewById(R.id.grid);
        populateCountries();
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            adapter = new CustomAdapterGrid(this, getResults(query));
        } else {
            adapter = new CustomAdapterGrid(this, countryList);
        }
        setListAdapter();
    }

    private ArrayList<Country> getResults(String query) {
        ArrayList<Country> result = new ArrayList<>();
        for (Country country : countryList) {
            if (country.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(country);
            }
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.searchAction:
                return onSearchRequested();
            case R.id.clear:
                adapter = new CustomAdapterGrid(this, countryList);
                setListAdapter();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void setListAdapter() {
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String toast = (((Country) parent.getItemAtPosition(position))).getName();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String toast = (((Country) parent.getItemAtPosition(position))).getCode();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void populateCountries() {
        for (Countries c : Countries.values()) {
            Country country = new Country(c);
            countryList.add(country);
        }
    }
}
