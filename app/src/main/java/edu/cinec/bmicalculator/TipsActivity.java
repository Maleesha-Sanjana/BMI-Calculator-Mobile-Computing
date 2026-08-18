package edu.cinec.bmicalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TipAdapter tipAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUtils.setupBottomNavigation(this, bottomNavigationView, R.id.tipsFragment);

        recyclerView = findViewById(R.id.recyclerViewTips);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Tip> tips = new ArrayList<>();
        tips.add(new Tip("Hydrate first", "Drink a glass of water when you wake up"));
        tips.add(new Tip("Move more", "Take the stairs instead of the lift"));
        tips.add(new Tip("Sleep well", "Aim for 7-8 hours of rest each night"));
        tips.add(new Tip("Stretch hourly", "Loosen up during long periods of sitting"));

        tipAdapter = new TipAdapter(tips);
        recyclerView.setAdapter(tipAdapter);
    }
}
