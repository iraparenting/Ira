package com.example.ira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class Grid_Adapter extends BaseAdapter
{
    ArrayList<String> arrayList_string;
    Context context;

    public long getItemId(int i)
    {
        return (long) i;
    }

    public Grid_Adapter(Context context2, ArrayList<String> arrayList)
    {
        this.context = context2;
        this.arrayList_string = arrayList;
    }

    public int getCount()
    {
        return this.arrayList_string.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup)

    {
        return LayoutInflater.from(this.context).inflate(R.layout.grid, viewGroup, false);
    }
}
