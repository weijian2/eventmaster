package com.example.daniel.eventmaster;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private Button mRegisterButton;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // The savedInstanceState parameter is a Bundle that provides data about the previous instance of the fragment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Life cycle test", "We are at Activity1 onCreate()");
        this.mUsernameEditText = (EditText) findViewById(R.id.username);
        this.mPasswordEditText = (EditText) findViewById(R.id.password);
        this.mLoginButton = (Button) findViewById(R.id.login);
        this.mRegisterButton = (Button) findViewById(R.id.register);
        // Firebase uses singleton to initialize the sdk(firebase)
        this.mDatabase = FirebaseDatabase.getInstance().getReference();

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
