package com.example.daniel.eventmaster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by daniel on 3/11/18.
 */

public class EventAdapter extends BaseAdapter {
    Context context;
    List<Event> eventData;

    public EventAdapter(Context context) {
        this.context = context;
        this.eventData = DataService.getEventData();
    }

    @Override
    public int getCount() {
        return eventData.size();
    }

    @Override
    public Event getItem(int position) {
        return eventData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * draw view on each low of ListView.
     * @param position index of this event in data.
     * @param convertView View representation of this event
     * @param parent container of this event(ListView).
     * @return constructed View representation of this event.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Log.e("getView test", "Get one view");
        if (convertView == null) {
            // 打气筒
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            // transfer xml object to java object（将这个View转变成我们在xml里定义好的样子）
            convertView = inflater.inflate(R.layout.event_item,
                    parent, false);
        }

        TextView eventTitle = (TextView) convertView.findViewById(R.id.event_title);
        TextView eventAddress = (TextView) convertView.findViewById(R.id.event_address);
        TextView eventDescription = (TextView) convertView.findViewById(R.id.event_content);
        ImageView eventLogo = (ImageView) convertView.findViewById(R.id.event_logo);

        Event r = eventData.get(position);
        eventTitle.setText(r.getTitle());
        eventAddress.setText(r.getAddress());
        eventDescription.setText(r.getContent());
        if (position < 3) {
            eventLogo.setImageDrawable(context.getDrawable(R.drawable.gsw));
        } else if (position >=3 && position < 6) {
            eventLogo.setImageDrawable(context.getDrawable(R.drawable.lakers));
        } else {
            eventLogo.setImageDrawable(context.getDrawable(R.drawable.phi));
        }

        return convertView;
    }

}
