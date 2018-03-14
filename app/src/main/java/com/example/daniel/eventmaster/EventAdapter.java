package com.example.daniel.eventmaster;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
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
            // Inflate the layout for this view
            // first para: The resource ID of the layout you want to inflate.

            // second para: The ViewGroup to be the parent of the inflated layout. Passing the
            // parent is important in order for the system to apply layout parameters to the
            // root view of the inflated layout, specified by the parent view in which it's going.

            // third para: A boolean indicating whether the inflated layout should be attached
            // to the ViewGroup (the second parameter) during inflation. (In this case, this is
            // false because the system is already inserting the inflated layout into the
            // container—passing true would create a redundant view group in the final layout.)
            convertView = inflater.inflate(R.layout.event_item,
                    parent, false);
        }

        TextView eventTitle = (TextView) convertView.findViewById(R.id.event_title);
        TextView eventAddress = (TextView) convertView.findViewById(R.id.event_address);
        TextView eventDescription = (TextView) convertView.findViewById(R.id.event_content);
        ImageView eventLogo = (ImageView) convertView.findViewById(R.id.event_logo);

        // get current event
        Event r = eventData.get(position);
        // set event title
        eventTitle.setText(r.getTitle());
        // set event address
        eventAddress.setText(r.getAddress());
        // set event content
        eventDescription.setText(r.getContent());
        // set event logo
        if (position < 3) {
            eventLogo.setImageDrawable(LoadImageFromWebOperations("https://cdn-s3.si.com/s3fs-public/styles/marquee_large_2x/public/2017/10/15/stephen-curry-warriors-preseason.jpg?itok=e3EkDu-G"));
        } else if (position >=3 && position < 6) {
            eventLogo.setImageDrawable(context.getDrawable(R.drawable.lakers));
        } else {
            eventLogo.setImageDrawable(context.getDrawable(R.drawable.phi));
        }

        return convertView;
    }

    private Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

}
