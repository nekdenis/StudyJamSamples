package com.studyjam.samples.imagelist.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.data.dto.ImageResult;

import java.util.List;

public class ImagePreviewAdapter extends ArrayAdapter<ImageResult> {

    private LayoutInflater inflater;
    private DisplayImageOptions displayImageOptions;

    public ImagePreviewAdapter(Context context, List<ImageResult> objects) {
        super(context, R.layout.item_image_preview, objects);
        inflater = LayoutInflater.from(context);
        displayImageOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_image_preview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageResult item = getItem(position);
        viewHolder.populate(item);
        return convertView;

    }

    private class ViewHolder {

        private ImageView imageView;
        private TextView name;

        private ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image_preview);
            name = (TextView) view.findViewById(R.id.image_name);
        }

        private void populate(ImageResult item) {
            ImageLoader.getInstance().displayImage(item.getThumbnailUrl(), imageView, displayImageOptions);
            name.setText(Html.fromHtml(item.getContent()));
        }
    }
}
