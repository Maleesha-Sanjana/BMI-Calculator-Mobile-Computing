package edu.cinec.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private EditText etHeight, etWeight;
    private Button btnCalBMI;
    private TextView tvAnswer, tvBMIScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUtils.setupBottomNavigation(this, bottomNavigationView, R.id.bmiFragment);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalBMI = findViewById(R.id.btnCalBMI);
        tvAnswer = findViewById(R.id.tvAnswer);
        tvBMIScore = findViewById(R.id.tvBMIScore);

        btnCalBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = etHeight.getText().toString().trim();
                String weightStr = etWeight.getText().toString().trim();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter height and weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                float heightCm = Float.parseFloat(heightStr);
                float weightKg = Float.parseFloat(weightStr);

                // Convert height from cm to meters
                float heightM = heightCm / 100;

                // Calculate BMI
                float bmi = weightKg / (heightM * heightM);
                
                // Show BMI score
                tvBMIScore.setText(String.format("%.1f", bmi));

                // Determine category
                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25) {
                    category = "Normal";
                } else {
                    category = "Overweight";
                }

                tvAnswer.setText(category);
            }
        });
    }
}