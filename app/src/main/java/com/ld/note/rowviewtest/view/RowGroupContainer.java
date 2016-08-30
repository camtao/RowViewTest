package com.ld.note.rowviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ld.note.rowviewtest.model.GroupDescytor;
import com.ld.note.rowviewtest.inter.OnRowClickListener;

import java.util.ArrayList;

/**
 * Created by 10607 on 2016/8/30.
 */
public class RowGroupContainer extends LinearLayout {
    private  Context context;
    private OnRowClickListener listener;
    private ArrayList<GroupDescytor> groupDescytors;

    public RowGroupContainer(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public RowGroupContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    public RowGroupContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
    }


    public void setData(ArrayList<GroupDescytor> groupDescytors) {
       this.groupDescytors=groupDescytors;
    }

    public void notifyDataChanged(){
        LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        float density = context.getResources().getDisplayMetrics().density;
        params.topMargin= (int) (20*density);
        for (int i = 0; i <groupDescytors.size(); i++) {
            GroupDescytor groupDescytor = groupDescytors.get(i);
            RowGroupView rowGroupView = new RowGroupView(context);
            rowGroupView.setListener(listener);
            rowGroupView.setData(groupDescytor.rowDescrytors);
            rowGroupView.notifyDataChanged();
            addView(rowGroupView,params);
        }
    }

    public void setListener(OnRowClickListener listener) {
        this.listener=listener;
    }
}
