package com.ld.note.rowviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.inter.ICreateRowView;
import com.ld.note.rowviewtest.inter.OnRowClickListener;

import java.util.ArrayList;

/**
 * Created by 10607 on 2016/8/30.
 */
public class RowGroupView extends LinearLayout {
    private  Context context;
    private OnRowClickListener listener;
    private ArrayList<BaseRowDescrytor> rowDescrytors;

    public RowGroupView(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public RowGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    public RowGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
    }

    public void setListener(OnRowClickListener listener) {
        this.listener = listener;
    }

    public  void setData(ArrayList<BaseRowDescrytor> rowDescrytors) {
        this.rowDescrytors=rowDescrytors;
    }

    public void notifyDataChanged(){
        View view=null;
        LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
        float density = context.getResources().getDisplayMetrics().density;
        params.leftMargin= (int) (10*density);
        for (int i = 0; i <rowDescrytors.size() ; i++) {
            view=new View(context);
            BaseRowDescrytor rowDescrytor = rowDescrytors.get(i);
            ICreateRowView rowView= rowDescrytor.createRowView(context);
            rowView.setData(rowDescrytor,listener);
            addView((View) rowView);
            if (i!=(rowDescrytors.size()-1)){
                addView(view,params);
            }
        }
    }
}
