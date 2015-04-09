package com.studyjam.samples.imagelist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.data.dto.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonSlowListAdapter extends ArrayAdapter<Person> {

    private LayoutInflater inflater;
    private DisplayImageOptions displayImageOptions;

    public PersonSlowListAdapter(Context context) {
        super(context, 0);
        inflater = LayoutInflater.from(context);
        displayImageOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long startTime = System.nanoTime();

        convertView = inflater.inflate(R.layout.person_list_item, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.person_list_item_name);
        ImageView icon = (ImageView) convertView.findViewById(R.id.person_list_item_image);
        TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);

        Person person = getItem(position);

        name.setText(person.getName());
        ImageLoader.getInstance().displayImage(person.getImageUrl(), icon,
                displayImageOptions);
        timestamp.setText(new SimpleDateFormat().format(new Date()));


        Log.d("PersonSlowListAdapter", "getView takes "+(System.nanoTime()-startTime)/1000);
        return convertView;
    }
}
