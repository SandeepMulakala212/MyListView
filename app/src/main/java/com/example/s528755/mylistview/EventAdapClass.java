package com.example.s528755.mylistview;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by S528755 on 10/2/2017.
 */

public class EventAdapClass extends ArrayAdapter {
    public EventAdapClass(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull ArrayList<NameCount> objects) {
        super(context, resource, textViewResourceId, objects);
}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        TextView tv1 = (TextView) v.findViewById(R.id.textV1);
        TextView tv2 = (TextView) v.findViewById(R.id.textV2);

//        NameCount jo = (NameCount) getItem(position);
        NameCount jo = (NameCount) getItem(position);
        tv1.setText(jo.getName());
        tv2.setText(jo.getcount().toString());
        return v;
    }
}

