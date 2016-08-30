package com.ld.note.rowviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ld.note.rowviewtest.inter.OnRowClickListener;
import com.ld.note.rowviewtest.model.BaseRowDescrytor;
import com.ld.note.rowviewtest.model.GroupDescytor;
import com.ld.note.rowviewtest.model.RowDescrytor;
import com.ld.note.rowviewtest.model.SpecialRowDescytor;
import com.ld.note.rowviewtest.view.RowGroupContainer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRowClickListener {

    private RowGroupContainer rowContianerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndData();
    }

    private void initViewAndData() {
        rowContianerView = (RowGroupContainer) findViewById(R.id.row_container);

        ArrayList<GroupDescytor> groupDescytors = new ArrayList<>();

        GroupDescytor groupDescytor0 = new GroupDescytor();
        ArrayList<BaseRowDescrytor> rowDescrytors0=new ArrayList<>();
        SpecialRowDescytor rowDescrytor0= new SpecialRowDescytor(R.mipmap.chat_tool_funny_face, R.string.CHAT_TOOL_FACE,R.string.FACE_CONTENT, RowAction.FACE);
        rowDescrytors0.add(rowDescrytor0);
        groupDescytor0.rowDescrytors=rowDescrytors0;

        groupDescytors.add(groupDescytor0);

        GroupDescytor groupDescytor = new GroupDescytor();
        ArrayList<BaseRowDescrytor> rowDescrytors=new ArrayList<>();
//        RowDescrytor rowDescrytor = new RowDescrytor(R.mipmap.chat_tool_audio, R.string.CHAT_TOOL_AUDIO, RowAction.AUDIO);
        RowDescrytor rowDescrytor = new RowDescrytor(R.mipmap.chat_tool_audio, R.string.CHAT_TOOL_AUDIO);
        RowDescrytor rowDescrytor1 = new RowDescrytor(R.mipmap.chat_tool_camera, R.string.CHAT_TOOL_CAMERA, RowAction.CAMERA);
        RowDescrytor rowDescrytor2 = new RowDescrytor(R.mipmap.chat_tool_location, R.string.CHAT_TOOL_LOCATION);
        rowDescrytors.add(rowDescrytor);
        rowDescrytors.add(rowDescrytor1);
        rowDescrytors.add(rowDescrytor2);

        groupDescytor.rowDescrytors=rowDescrytors;
        groupDescytors.add(groupDescytor);

        GroupDescytor groupDescytor2 = new GroupDescytor();
        ArrayList<BaseRowDescrytor> rowDescrytors2=new ArrayList<>();
        RowDescrytor rowDescrytor4= new RowDescrytor(R.mipmap.chat_tool_emotion, R.string.CHAT_TOOL_AEMOTION, RowAction.EMOTION);
        rowDescrytors2.add(rowDescrytor4);
        groupDescytor2.rowDescrytors=rowDescrytors2;

        groupDescytors.add(groupDescytor2);

        rowContianerView.setListener(this);
        rowContianerView.setData(groupDescytors);
        rowContianerView.notifyDataChanged();
    }

    @Override
    public void onRowClick(RowAction rowAction) {
        Toast.makeText(this,rowAction.name(),Toast.LENGTH_LONG).show();
    }
}
