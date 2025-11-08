package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Product product);
        void onBuyClick(Product product);
        void onLongClick(Product product);
    }

    public ProductAdapter(List<Product> productList, OnItemClickListener listener) {
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product, listener);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription, tvPrice, tvRating;
        Button btnBuy;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvProductName);
            tvDescription = itemView.findViewById(R.id.tvProductDescription);
            tvPrice = itemView.findViewById(R.id.tvProductPrice);
            tvRating = itemView.findViewById(R.id.tvProductRating);
            btnBuy = itemView.findViewById(R.id.btnBuy);
        }

        public void bind(Product product, OnItemClickListener listener) {
            tvName.setText(product.getName());
            tvDescription.setText(product.getDescription());
            tvPrice.setText(product.getPrice());
            tvRating.setText(product.getRating());

            // Click vào item
            itemView.setOnClickListener(v -> listener.onItemClick(product));

            // Long click vào item
            itemView.setOnLongClickListener(v -> {
                listener.onLongClick(product);
                return true;
            });

            // Click vào button Mua
            btnBuy.setOnClickListener(v -> listener.onBuyClick(product));
        }
    }
}