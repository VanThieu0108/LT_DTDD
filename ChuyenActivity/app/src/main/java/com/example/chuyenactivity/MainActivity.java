package com.example.chuyenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Xử lý sự kiện click button Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Kiểm tra username và password không rỗng
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter username and password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển sang ProfileActivity và truyền dữ liệu
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });
    }
}