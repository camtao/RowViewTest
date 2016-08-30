package com.ld.note.rowviewtest.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.R;
import com.ld.note.rowviewtest.RowAction;
import com.ld.note.rowviewtest.model.RowDescrytor;
import com.ld.note.rowviewtest.inter.ICreateRowView;
import com.ld.note.rowviewtest.inter.OnRowClickListener;

/**
 * Created by 10607 on 2016/8/30.
 */
public class RowView extends LinearLayout implements ICreateRowView {
    private  Context context;
    private ImageView img;
    private TextView tvLable;
    private ImageView ivAction;
    private int imgRsId;
    private int lableRsid;
    private RowAction rowAction;
    private OnRowClickListener listener;

    public RowView(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public RowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    public RowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();

    }

    private void initView() {
        setOrientation(HORIZONTAL);
        setBackgroundColor(Color.BLUE);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.layout_row_view,this);
        img = (ImageView) findViewById(R.id.img);
        tvLable = (TextView) findViewById(R.id.tv_lable);
        ivAction = (ImageView) findViewById(R.id.iv_action);
    }

    private void notifyDataChanged() {
        img.setImageResource(imgRsId);
        tvLable.setText(lableRsid);
        if (rowAction!=null){
            ivAction.setVisibility(View.VISIBLE);
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRowClick(rowAction);
                }
            });
        }else{
            ivAction.setVisibility(View.GONE);
        }
    }

    @Override
    public void setData(BaseRowDescrytor descrytor, OnRowClickListener listener) {
        this.imgRsId=((RowDescrytor)descrytor).imgRsId;
        this.lableRsid=((RowDescrytor)descrytor).lableRsId;
        this.rowAction=((RowDescrytor)descrytor).rowAction;
        this.listener=listener;
        notifyDataChanged();
    }
}
