package com.example.daniel.eventmaster;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    private ListView mListView;
    private OnItemSelectListener mCallback;

    // Container Activity must implement this interface
    public interface OnItemSelectListener {
        public void onItemSelected(int position);
    }

    public EventFragment() {
        // Required empty public constructor
    }

    // Change color if comment is selected
    public void onCommentSelected(int position) {
        for (int i = 0; i < mListView.getChildCount(); i++){
            if (position == i) {
                mListView.getChildAt(i).setBackgroundColor(Color.GREEN);
            } else {
                // mListView.getChildAt(i).setBackgroundColor(Color.RED);
                mListView.getChildAt(i).setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Fragment cycle test", "We are at onAttach()");
        try {
            mCallback = (OnItemSelectListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnItemSelectListener");
        }
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
        mListView = (ListView) view.findViewById(R.id.event_list);
        // listView.setAdapter(new EventAdapter(getActivity()));

        // android.R.layout.simple_list_item_1 is built-in XML layout document that is part
        // of the Android OS, rather than one of your own XML layouts
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getEventNames());

        // Assign adapter to ListView.
        mListView.setAdapter(adapter);

        // Add click listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onItemSelected(i);
            }
        });

        return view;

    }

    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;

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
