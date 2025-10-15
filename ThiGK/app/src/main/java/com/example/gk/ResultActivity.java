package com.example.gk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class ResultActivity extends AppCompatActivity {
    TextView tvBMI, tvStatus, tvInfo;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvBMI = findViewById(R.id.tvBMI);
        tvStatus = findViewById(R.id.tvStatus);
        tvInfo = findViewById(R.id.tvInfo);
        btnBack = findViewById(R.id.btnBack);
// Nhận dữ liệu từ màn hình 1
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI", 0);
        double height = intent.getDoubleExtra("HEIGHT", 0);
        double weight = intent.getDoubleExtra("WEIGHT", 0);
// Hiển thị kết quả
        tvBMI.setText(String.format("%.1f", bmi));
        tvInfo.setText("Chiều cao: " + height + "cm | Cân nặng: " + weight + "kg");
// Xử lý logic phân loại
        String status;
        if (bmi < 18.5) {
            status = "Thiếu cân";
        } else if (bmi < 24.9) {
            status = "Bình thường";
        } else if (bmi < 29.9) {
            status = "Thừa cân";
        } else {
            status = "Béo phì";
        }
        tvStatus.setText(status);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}