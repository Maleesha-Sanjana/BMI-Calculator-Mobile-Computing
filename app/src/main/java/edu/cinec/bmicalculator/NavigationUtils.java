package edu.cinec.bmicalculator;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationUtils {
    public static void setupBottomNavigation(Activity activity, BottomNavigationView bottomNavigationView, int currentItemId) {
        bottomNavigationView.setSelectedItemId(currentItemId);
        
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == currentItemId) {
                return true;
            }
            
            Intent intent = null;
            if (itemId == R.id.bmiFragment) {
                intent = new Intent(activity, MainActivity.class);
            } else if (itemId == R.id.tipsFragment) {
                intent = new Intent(activity, TipsActivity.class);
            } else if (itemId == R.id.eatingFragment) {
                intent = new Intent(activity, EatingActivity.class);
            } else if (itemId == R.id.adviceFragment) {
                intent = new Intent(activity, AdviceActivity.class);
            }
            
            if (intent != null) {
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0); // Disable transition animation
                return true;
            }
            return false;
        });
    }
}
