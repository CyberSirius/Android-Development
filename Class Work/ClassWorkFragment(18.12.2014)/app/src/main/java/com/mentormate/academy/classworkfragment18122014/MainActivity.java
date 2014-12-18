package com.mentormate.academy.classworkfragment18122014;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Log.wtf("Fragment", "onCreateView");

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            Log.wtf("Fragment", "onAttach");
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.wtf("Fragment", "onCreate");

        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.wtf("Fragment", "onActivityCreated");

        }

        @Override
        public void onStart() {
            super.onStart();
            Log.wtf("Fragment", "onStart");


        }

        @Override
        public void onResume() {
            super.onResume();
            Log.wtf("Fragment", "onResume");

        }

        @Override
        public void onPause() {
            super.onPause();
            Log.wtf("Fragment", "onPause");

        }

        @Override
        public void onStop() {
            super.onStop();
            Log.wtf("Fragment", "onStop");

        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.wtf("Fragment", "onDestroy");

        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.wtf("Fragment", "onDestroyView");

        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.wtf("Fragment", "onDetach");

        }
    }
}
