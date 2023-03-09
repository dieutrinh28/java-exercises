package com.example.gridview_image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private ArrayList<Item> itemArrayList;
    private Context context;

    public ItemAdapter(ArrayList<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final MyView dataItem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            dataItem = new MyView();
            view = inflater.inflate(R.layout.activity_view_detail, null);
            dataItem.imageView = view.findViewById(R.id.item_image);
            dataItem.textViewTitle = view.findViewById(R.id.item_title);
            dataItem.textViewDescription = view.findViewById(R.id.item_description);
            view.setTag(dataItem);
        }
        else {
            dataItem = (MyView) view.getTag();
        }

        Picasso.get().load(itemArrayList.get(i).getImage()).resize(300,400).centerCrop().into(dataItem.imageView);
        dataItem.textViewTitle.setText(itemArrayList.get(i).getTitle());
        dataItem.textViewDescription.setText(itemArrayList.get(i).getDescription());
        return view;
    }

    private static class MyView {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;

    }
}
