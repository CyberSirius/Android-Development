package com.example.lyubo.classassignmentsix;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    GridView list;
    CustomAdapterGrid customAdapter;

    private String[] countriesLs = new String[]{"Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France"};
    private String[] codes = new String[]{"AUS", "BEL", "BG", "CRO", "CYP",
            "CZ", "DEN", "EST", "FIN", "FR"};
    private ArrayList<Country> countryList = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (GridView) findViewById(R.id.grid);
        populateCountries();
        handleIntent(getIntent());
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((Country) parent.getItemAtPosition(position)).getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((Country) parent.getItemAtPosition(position)).getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.searchAction:
                return onSearchRequested();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(SearchManager.QUERY).toLowerCase();//toLowerCase if its necessary
            Log.wtf("Query is", stringExtra);
            customAdapter = new CustomAdapterGrid(this, getResults(stringExtra));
        } else {
            customAdapter = new CustomAdapterGrid(this, countryList);

        }
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

    private void populateCountries() {
        for (int i = 0; i < countriesLs.length; i++) {
            Country cnt = new Country(countriesLs[i], codes[i]);
            countryList.add(cnt);
        }
    }
}
