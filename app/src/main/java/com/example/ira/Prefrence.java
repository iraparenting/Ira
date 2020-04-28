package com.example.ira;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class Prefrence extends AppCompatActivity
{
    ArrayList<String> arrayList;
    ExpandableHeightGridView grid;

    @Override
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_prefrence);
        this.grid = (ExpandableHeightGridView) findViewById(R.id.grid);
        findViewById(R.id.submit).setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                Prefrence.this.startActivity(new Intent(Prefrence.this, Youtube_Video.class));
            }
        });
        this.arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            ArrayList<String> arrayList2 = this.arrayList;
            StringBuilder sb = new StringBuilder();
            sb.append(BuildConfig.FLAVOR);
            sb.append(i);
            arrayList2.add(sb.toString());
        }
        this.grid.setAdapter(new Grid_Adapter(this, this.arrayList));
        this.grid.setExpanded(true);
    }

    public void setGridViewHeightBasedOnChildren(GridView gridView, int i)
    {
        ListAdapter adapter = gridView.getAdapter();
        if (adapter != null)
        {
            int count = adapter.getCount();
            View view = adapter.getView(0, null, gridView);
            view.measure(0, 0);
            int measuredHeight = view.getMeasuredHeight();
            if (count > i)
            {
                measuredHeight *= (int) (((float) (count / i)) + 1.0f);
            }
            LayoutParams layoutParams = gridView.getLayoutParams();
            layoutParams.height = measuredHeight;
            gridView.setLayoutParams(layoutParams);
        }
    }
}
