package com.ld.note.rowviewtest.model;

import android.content.Context;

import com.ld.note.rowviewtest.RowAction;
import com.ld.note.rowviewtest.inter.ICreateRowView;
import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.view.SpecialRowView;

/**
 * Created by 10607 on 2016/8/30.
 */
public class SpecialRowDescytor extends BaseRowDescrytor {
    public int imgRsId;
    public int lableRsId;
    public int contentRsId;

    public SpecialRowDescytor(int imgRsId, int lableRsId, int contentRsId) {
        this.imgRsId = imgRsId;
        this.lableRsId = lableRsId;
        this.contentRsId = contentRsId;
    }

    public SpecialRowDescytor(int imgRsId, int lableRsId, int contentRsId,RowAction rowAction) {
        this.imgRsId = imgRsId;
        this.lableRsId = lableRsId;
        this.contentRsId = contentRsId;
        this.rowAction=rowAction;
    }

    @Override
    public ICreateRowView createRowView(Context context) {
        return new SpecialRowView(context);
    }
}
