package edu.cinec.bmicalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUtils.setupBottomNavigation(this, bottomNavigationView, R.id.adviceFragment);
    }
}
