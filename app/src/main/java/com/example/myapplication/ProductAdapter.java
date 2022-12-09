package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<Product> productList;
    private ArrayList<Product> dataitem;


    public ProductAdapter(Context context, List<Product> productList){
        this.context = context;
        this.productList = productList;
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.view_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.judul.setText(productList.get(position).getTitle());
        holder.kategori.setText(productList.get(position).getCategory());
        String[] datastring = {productList.get(position).getTitle(),productList.get(position).getCategory(),productList.get(position).getImage(),productList.get(position).getDescription()};
        Glide.with(context)
                .load(this.productList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.image);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailProduct.class);
                intent.putExtra("datastring", datastring);
                context.startActivity(intent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return this.productList.size();
    }


    public void filterList(List<Product> filteredList){
        productList = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        TextView kategori;
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.textView);
            kategori = itemView.findViewById(R.id.textView2);
            image = itemView.findViewById(R.id.imageView);

        }

    }



}
