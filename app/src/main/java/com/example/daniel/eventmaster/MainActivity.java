package com.example.daniel.eventmaster;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements EventFragment.OnItemSelectListener, CommentFragment.OnCommentSelectListener {

    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    @Override
    public void onItemSelected(int position) {
        if (!isTablet()) {
            // we need to use explicit intent to start EventGridActivity which hols the CommentFragment
            // this stands for current context(mainActivity)
            Intent intent = new Intent(this, EventGridActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            mGridFragment.onItemSelected(position);
        }
    }

    @Override
    public void onCommentSelected(int position) {
        mListFragment.onCommentSelected(position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // The savedInstanceState parameter is a Bundle that provides data about the previous instance of the fragment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Life cycle test", "We are at Activity1 onCreate()");

//        // Get ListView object from activity_main.xml, transfer xml object to java object
//        ListView eventListView = (ListView) findViewById(R.id.event_list);
//
//        // Initialize an adapter, which used to transfer data from xml to java
//        EventAdapter adapter = new EventAdapter(this);
//
//        // Assign adapter to ListView
//        eventListView.setAdapter(adapter);

//        // Show different fragment based on different screen size
//        if (findViewById(R.id.fragment_container) != null) {
//            Fragment fragment = isTablet() ? new CommentFragment() : new EventFragment();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.fragment_container, fragment);
//            fragmentTransaction.commit();
//        }

        //add list view
        mListFragment = new EventFragment();
        // getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mListFragment).commit();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.event_container, mListFragment);
        fragmentTransaction.commit();

        //add Gridview
        if (isTablet()) {
            mGridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, mGridFragment).commit();

        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("textmessage");
        myRef.setValue("Hi there, I am Daniel");
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at Activity1 onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at Activity1 onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at Activity1 onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at Activity1 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at Activity1 onDestroy()");
    }

}
