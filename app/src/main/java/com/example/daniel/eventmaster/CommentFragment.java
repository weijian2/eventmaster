package com.example.daniel.eventmaster;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment {
    private GridView mGridView;
    private OnCommentSelectListener mCallback;

    // Container Activity must implement this interface
    public interface OnCommentSelectListener {
        public void onCommentSelected(int position);
    }

    public CommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnCommentSelectListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnItemSelectListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        // transfer xml object to java object
        mGridView = (GridView) view.findViewById(R.id.comment_grid);
        mGridView.setAdapter(new EventAdapter(getActivity()));

        // Add click listener
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onCommentSelected(i);
            }
        });

        return view;
    }

    // Change background color if the item is selected
    public void onItemSelected(int position) {
        for (int i = 0; i < mGridView.getChildCount(); i++){
            if (position == i) {
                mGridView.getChildAt(i).setBackgroundColor(Color.GREEN);
            } else {
                // mGridView.getChildAt(i).setBackgroundColor(Color.RED);
                mGridView.getChildAt(i).setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }
    }

}
