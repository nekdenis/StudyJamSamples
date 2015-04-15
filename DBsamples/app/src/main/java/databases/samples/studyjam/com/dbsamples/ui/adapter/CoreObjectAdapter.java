package databases.samples.studyjam.com.dbsamples.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import databases.samples.studyjam.com.dbsamples.R;
import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dto.CoreObject;

public class CoreObjectAdapter extends ArrayAdapter<CoreObject> {

    private final LayoutInflater inflater;

    public CoreObjectAdapter(Context context, List<CoreObject> objects) {
        super(context, R.layout.item_core_object, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inflater.inflate(R.layout.item_core_object, parent, false);
        }
        ViewHolder holder = (ViewHolder) row.getTag();
        if (holder == null) {
            holder = new ViewHolder(row);
            row.setTag(holder);
        }
        final CoreObject item = getItem(position);
        holder.inflate(item);
        return row;
    }

    private class ViewHolder {

        public TextView name;
        public ImageView imageView;

        public ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.item_core_object_name);
            imageView = (ImageView) view.findViewById(R.id.item_core_object_image);
        }

        public void inflate(CoreObject item) {
            name.setText(item.getName());


        }

    }

}