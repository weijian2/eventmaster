package com.example.daniel.eventmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // The savedInstanceState parameter is a Bundle that provides data about the previous instance of the fragment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from activity_main.xml, transfer xml object to java object
        ListView eventListView = (ListView) findViewById(R.id.event_list);

        // Initialize an adapter, which used to transfer data from xml to java
        EventAdapter adapter = new EventAdapter(this);

        // Assign adapter to ListView
        eventListView.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

}
