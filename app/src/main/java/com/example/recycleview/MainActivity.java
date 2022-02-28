package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }
    public void initView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_viewwwww);
        recyclerView.setHasFixedSize(true);//tối ưu hóa dữ liệu không bị ảnh hưởng nd trong adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.samsung,"Sam Sung"));
        arrayList.add(new DataShop(R.drawable.iphone,"Iphone "));
        arrayList.add(new DataShop(R.drawable.vsmart,"Vsmart"));

        ShopAdapter shopAdapter= new ShopAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(shopAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.customer_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}