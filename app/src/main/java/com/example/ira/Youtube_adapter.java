package com.example.ira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class Youtube_adapter extends BaseAdapter
{
    ArrayList<Youtube_cat_model> arrayList;
    Context context;

    public long getItemId(int i)
    {
        return (long) i;
    }

    public Youtube_adapter(Context context2, ArrayList<Youtube_cat_model> arrayList2)
    {
        this.context = context2;
        this.arrayList = arrayList2;
    }

    public int getCount()
    {
        return this.arrayList.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup)
            /*
            1. Get the root view
            2. Use the root view to find other views
            3. Set the values
             */
    {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.listview, viewGroup, false);

        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        TextView textView = (TextView) inflate.findViewById(R.id.chtitle);

        ((TextView) inflate.findViewById(R.id.title)).setText(((Youtube_cat_model) this.arrayList.get(i)).getTitle());
        textView.setText(((Youtube_cat_model) this.arrayList.get(i)).getChannelTitle());
        Glide.with(this.context).load(((Youtube_cat_model) this.arrayList.get(i)).getUrl()).into(imageView);

        return inflate;
    }
}
