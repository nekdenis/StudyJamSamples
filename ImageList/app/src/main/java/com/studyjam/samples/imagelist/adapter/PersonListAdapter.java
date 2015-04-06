package com.studyjam.samples.imagelist.adapter;

import android.content.Context;
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

public class PersonListAdapter extends ArrayAdapter<Person> {

    public PersonListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.person_list_item, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.person_list_item_name);
            holder.icon = (ImageView) convertView.findViewById(R.id.person_list_item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Person person = getItem(position);
        holder.populateItem(person);
        return convertView;
    }

    static class ViewHolder {
        TextView name;
        ImageView icon;

        void populateItem(Person person){
            name.setText(person.getName());
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .resetViewBeforeLoading(true)
                    .build();
            ImageLoader.getInstance().displayImage(person.getImageUrl(), icon, options);
        }
    }
}
