package com.ld.note.rowviewtest.model;

import android.content.Context;

import com.ld.note.rowviewtest.RowAction;
import com.ld.note.rowviewtest.inter.ICreateRowView;
import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.view.RowView;

/**
 * Created by 10607 on 2016/8/30.
 */
public class RowDescrytor extends BaseRowDescrytor {

    public int imgRsId;
    public int lableRsId;

    public RowDescrytor(int imgRsId, int lableRsId,RowAction rowAction) {
        this.imgRsId = imgRsId;
        this.lableRsId = lableRsId;
        this.rowAction=rowAction;
    }


    public RowDescrytor(int imgRsId, int lableRsId) {
        this.imgRsId = imgRsId;
        this.lableRsId = lableRsId;
    }


    @Override
    public ICreateRowView createRowView(Context context) {
        return new RowView(context);
    }
}
