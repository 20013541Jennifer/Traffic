package com.myapplicationdev.android.traffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<cameras> camList;

    public CustomAdapter (Context context, int resource, ArrayList<cameras> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        camList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvCamId = rowView.findViewById(R.id.tvCameraId);
        //TextView tvImageId = rowView.findViewById(R.id.tvImageId);
       TextView tvTime= rowView.findViewById(R.id.tvTime);
        ImageView iv = rowView.findViewById(R.id.imageView);

        cameras currentCam = camList.get(position);
        tvCamId.setText(String.valueOf(currentCam.getCameraId()));
        //tvTime.setText(currentCam.get+"");
        tvTime.setText(currentCam.getTimestamp());

        String imageURL = currentCam.getImageURL();
        Picasso.with(parent_context).load(imageURL).into(iv);
        return rowView;
    }
}
