package com.ld.note.rowviewtest.model;

import android.content.Context;

import com.ld.note.rowviewtest.RowAction;
import com.ld.note.rowviewtest.inter.ICreateRowView;

/**
 * Created by 10607 on 2016/8/30.
 */
public abstract class BaseRowDescrytor {
    public RowAction rowAction;
    public abstract ICreateRowView createRowView(Context context);
}
