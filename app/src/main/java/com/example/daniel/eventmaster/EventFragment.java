package com.example.daniel.eventmaster;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Fragment cycle test", "We are at onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Fragment cycle test", "We are at onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("Fragment Life cycle test", "We are at onCreateView()");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ListView listView = (ListView) view.findViewById(R.id.event_list);
        listView.setAdapter(new EventAdapter(getActivity()));
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Fragment cycle test", "We are at onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("Fragment cycle test", "We are at onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Fragment cycle test", "We are at onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Fragment cycle test", "We are at onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("Fragment cycle test", "We are at onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Fragment cycle test", "We are at onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Fragment cycle test", "We are at onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("Fragment cycle test", "We are at onDetach()");
    }


}
