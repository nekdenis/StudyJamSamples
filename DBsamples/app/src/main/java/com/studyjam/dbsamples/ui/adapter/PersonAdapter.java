package com.studyjam.dbsamples.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studyjam.dbsamples.R;
import com.studyjam.dbsamples.data.db.provider.person.PersonCursor;

public class PersonAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public PersonAdapter(Context context, Cursor c) {
        super(context, c, 0);
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        PersonCursor c = new PersonCursor(cursor);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(c.getFirstName());
        String lastName = c.getLastName();
        holder.lastnameTV.setText(TextUtils.isEmpty(lastName) ? "" : lastName);
        holder.age.setText(String.valueOf(c.getAge()));
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