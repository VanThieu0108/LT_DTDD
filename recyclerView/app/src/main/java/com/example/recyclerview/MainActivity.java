package com.example.recyclerview;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu mẫu
        productList = new ArrayList<>();
        productList.add(new Product("Laptop Gaming", "Intel Core i7, RTX 3060", "25,000,000đ", "⭐ 4.8"));
        productList.add(new Product("Điện thoại Xiaomi", "8GB RAM, 256GB ROM", "8,500,000đ", "⭐ 4.5"));
        productList.add(new Product("Tai nghe Bluetooth", "Chống ồn ANC, Pin 30h", "2,300,000đ", "⭐ 4.7"));
        productList.add(new Product("Bàn phím cơ", "Blue Switch, RGB LED", "1,800,000đ", "⭐ 4.6"));
        productList.add(new Product("Chuột Gaming", "16000 DPI, 7 nút bấm", "950,000đ", "⭐ 4.4"));
        productList.add(new Product("Màn hình 27 inch", "2K IPS, 144Hz", "6,200,000đ", "⭐ 4.9"));

        // Khởi tạo adapter với sự kiện click
        adapter = new ProductAdapter(productList, new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Toast.makeText(MainActivity.this,
                        "Đã chọn: " + product.getName(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBuyClick(Product product) {
                Toast.makeText(MainActivity.this,
                        "Mua hàng: " + product.getName() + " - " + product.getPrice(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(Product product) {
                Toast.makeText(MainActivity.this,
                        "Chi tiết: " + product.getDescription(),
                        Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }
}