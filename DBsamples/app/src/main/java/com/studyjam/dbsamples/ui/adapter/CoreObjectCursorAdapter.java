package com.studyjam.dbsamples.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.studyjam.dbsamples.dbsamples.R;
import com.studyjam.dbsamples.data.db.simplecursor.table.CoreObjectTable;

public class CoreObjectCursorAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CoreObjectCursorAdapter(Context context, Cursor c) {
        super(context, c, FLAG_REGISTER_CONTENT_OBSERVER);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();

        //Fill list item
        holder.name.setText(cursor.getString(cursor.getColumnIndex(CoreObjectTable.COLUMN_NAME)));
        String imageUrl = cursor.getString(cursor.getColumnIndex(CoreObjectTable.COLUMN_URL));
        Picasso.with(context).load(imageUrl).into(holder.imageView);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.item_core_object, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.name = (TextView) view.findViewById(R.id.item_core_object_name);
        viewHolder.imageView = (ImageView) view.findViewById(R.id.item_core_object_image);
        view.setTag(viewHolder);
        return view;
    }

    static class ViewHolder {
        public TextView name;
        public ImageView imageView;
    }

}