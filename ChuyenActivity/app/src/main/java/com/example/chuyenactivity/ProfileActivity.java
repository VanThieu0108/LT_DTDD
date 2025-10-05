package com.example.chuyenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageViewSettings;
    private ImageView imageViewBack;
    private TextView textViewProfileName;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo các view
        imageViewSettings = findViewById(R.id.imageViewSettings);
        imageViewBack = findViewById(R.id.imageViewBack);
        textViewProfileName = findViewById(R.id.textViewProfileName);
        textViewEmail = findViewById(R.id.textViewEmail);

        // Nhận dữ liệu username từ MainActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        // Hiển thị thông tin username
        if (username != null && !username.isEmpty()) {
            textViewProfileName.setText(username);
            textViewEmail.setText("email : " + username.toLowerCase() + "@email.com");
        }

        // Xử lý sự kiện click Settings icon - quay về Login
        imageViewSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về MainActivity (Login screen)
                finish(); // Đóng ProfileActivity và quay về màn hình trước
            }
        });

        // Xử lý sự kiện click Back icon
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về MainActivity
                finish();
            }
        });
    }
}