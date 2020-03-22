package com.itfitness.simplelistview;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SimpleListView simpleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView = findViewById(R.id.slv);
        initListDatas();
    }
    private void initListDatas() {
        ArrayList<ListDataBean> arrayList = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            ListDataBean listDataBean = new ListDataBean();
            listDataBean.setName(i+"");
            if(i%2==0){
                listDataBean.setColor(Color.GREEN);
            }else {
                listDataBean.setColor(Color.BLUE);
            }
            arrayList.add(listDataBean);
        }
        //设置数据
        simpleListView.setDatas(R.layout.item_simplelistview, arrayList, new SimpleListView.CovertViewListener<ListDataBean>() {
            @Override
            public void covert(View view, ListDataBean data) {
                View v = view.findViewById(R.id.item_simplelistview_v);
                TextView tvName = view.findViewById(R.id.item_simplelistview_tv_name);
                v.setBackgroundColor(data.getColor());
                tvName.setText(data.getName());
            }
        });
        //点击事件
        simpleListView.setOnItemClickListener(new SimpleListView.OnItemClickListener<ListDataBean>() {
            @Override
            public void onItemClick(int position, ListDataBean data) {
                Toast.makeText(MainActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 点击按钮更新数据
     * @param view
     */
    public void updateList(View view){
        ArrayList<ListDataBean> arrayList = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            ListDataBean listDataBean = new ListDataBean();
            listDataBean.setName((i+10)+"");
            if(i%2==0){
                listDataBean.setColor(Color.GREEN);
            }else {
                listDataBean.setColor(Color.BLUE);
            }
            arrayList.add(listDataBean);
        }
        simpleListView.updateDatas(arrayList);
    }
}
