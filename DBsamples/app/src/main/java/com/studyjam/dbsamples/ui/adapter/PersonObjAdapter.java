package com.studyjam.dbsamples.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteCursorAdapter;
import com.studyjam.dbsamples.R;
import com.studyjam.dbsamples.data.db.orm.dto.Person;

public class PersonObjAdapter extends OrmLiteCursorAdapter<Person, View> {

    private final LayoutInflater mInflater;

    public PersonObjAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void bindView(View view, Context context, Person person) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(person.getName());
        String lastName = person.getLastName();
        holder.lastnameTV.setText(TextUtils.isEmpty(lastName) ? "" : lastName);
        holder.age.setText(String.valueOf(person.getAge()));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        final View view = mInflater.inflate(R.layout.item_person, parent, false);
        viewHolder.name = (TextView) view.findViewById(R.id.item_person_name);
        viewHolder.lastnameTV = (TextView) view.findViewById(R.id.item_person_lastname);
        viewHolder.age = (TextView) view.findViewById(R.id.item_person_age);
        view.setTag(viewHolder);
        return view;
    }

    static class ViewHolder {
        public TextView name;
        public TextView lastnameTV;
        public TextView age;
    }
}