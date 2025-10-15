package com.example.gk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText editHeight, editWeight;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h = editHeight.getText().toString();
                String w = editWeight.getText().toString();
                if (h.isEmpty() || w.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                double height = Double.parseDouble(h);
                double weight = Double.parseDouble(w);
                double bmi = weight / ((height / 100) * (height / 100));
// Truyền dữ liệu sang màn hình 2
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("BMI", bmi);
                intent.putExtra("HEIGHT", height);
                intent.putExtra("WEIGHT", weight);
                startActivity(intent);
            }
        });
    }
}