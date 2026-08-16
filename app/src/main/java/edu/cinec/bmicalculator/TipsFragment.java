package edu.cinec.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TipsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TipAdapter tipAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTips);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Tip> tips = new ArrayList<>();
        tips.add(new Tip("Hydrate first", "Drink a glass of water when you wake up"));
        tips.add(new Tip("Move more", "Take the stairs instead of the lift"));
        tips.add(new Tip("Sleep well", "Aim for 7-8 hours of rest each night"));
        tips.add(new Tip("Stretch hourly", "Loosen up during long periods of sitting"));

        tipAdapter = new TipAdapter(tips);
        recyclerView.setAdapter(tipAdapter);

        return view;
    }
}
