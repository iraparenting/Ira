package com.example.ira;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import androidx.core.view.ViewCompat;

public class ExpandableHeightGridView extends GridView
{
    boolean expanded = false;

    public ExpandableHeightGridView(Context context)
    {
        super(context);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet, int i)
    {
        super(context, attributeSet, i);
    }

    public boolean isExpanded()
    {
        return this.expanded;
    }

    public void onMeasure(int i, int i2)
    {
        if (isExpanded())
        {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, MeasureSpec.UNSPECIFIED));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setExpanded(boolean z)
    {
        this.expanded = z;
    }
}
