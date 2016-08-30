package com.ld.note.rowviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.R;
import com.ld.note.rowviewtest.RowAction;
import com.ld.note.rowviewtest.model.SpecialRowDescytor;
import com.ld.note.rowviewtest.inter.ICreateRowView;
import com.ld.note.rowviewtest.inter.OnRowClickListener;

/**
 * Created by 10607 on 2016/8/30.
 */
public class SpecialRowView extends RelativeLayout implements ICreateRowView {

    private  Context context;
    private ImageView ivIcon;
    private TextView tvLable;
    private TextView tvContent;
    private int imgRsId;
    private int lableRsid;
    private RowAction rowAction;
    private OnRowClickListener listener;
    private ImageView ivAction;
    private int contentRsId;

    public SpecialRowView(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public SpecialRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    public SpecialRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.layout_special_row,this);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        ivAction = (ImageView) findViewById(R.id.iv_action);
        tvLable = (TextView) findViewById(R.id.tv_lable);
        tvContent = (TextView) findViewById(R.id.tv_content);
    }


    private void notifyDataChanged() {
        ivIcon.setImageResource(imgRsId);
        tvLable.setText(lableRsid);
        tvContent.setText(contentRsId);
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
        this.imgRsId=((SpecialRowDescytor)descrytor).imgRsId;
        this.lableRsid=((SpecialRowDescytor)descrytor).lableRsId;
        this.rowAction=((SpecialRowDescytor)descrytor).rowAction;
        this.contentRsId=((SpecialRowDescytor)descrytor).contentRsId;
        this.listener=listener;
        notifyDataChanged();
    }
}
