package com.ld.note.rowviewtest.inter;

import com.ld.note.rowviewtest.model.BaseRowDescrytor;

/**
 * Created by 10607 on 2016/8/30.
 */
public interface ICreateRowView {
    void setData(BaseRowDescrytor descrytor, OnRowClickListener listener);
}
