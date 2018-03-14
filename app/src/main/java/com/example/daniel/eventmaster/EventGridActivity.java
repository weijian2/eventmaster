package com.example.daniel.eventmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class EventGridActivity extends AppCompatActivity implements CommentFragment.OnCommentSelectListener {
    private int position;
    private CommentFragment commentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_grid);
        Intent intent = getIntent();
        this.position = intent.getIntExtra("position", 0);
        this.commentFragment = new CommentFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.grid_container, commentFragment).commit();
        Log.e("Life cycle test", "We are at Activity2 onStart()");
    }

    @Override
    public void onCommentSelected(int position) {
        // do nothing
    }

    @Override
    // Called when the current Window of the activity gains or loses focus.
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            commentFragment.onItemSelected(position);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at Activity2 onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at Activity2 onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at Activity2 onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at Activity2 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at Activity2 onDestroy()");
    }
}
