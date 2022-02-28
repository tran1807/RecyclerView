package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    @NonNull
    @Override
    //Tạo layout
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    //gán dữ liệu
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      holder.txtName.setText(dataShops.get(position).getTen());
      holder.imgHinh.setImageResource(dataShops.get(position).getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }
    public void removeItem(int position){
        dataShops.remove(position);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Khai báo
        TextView txtName;
        ImageView imgHinh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Ánh Xạ
            txtName = (TextView) itemView.findViewById(R.id.textviewName);
            imgHinh = (ImageView) itemView.findViewById(R.id.image_hinh);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(),"Remove",Toast.LENGTH_LONG).show();
                }
            });

        }
    }
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }
}