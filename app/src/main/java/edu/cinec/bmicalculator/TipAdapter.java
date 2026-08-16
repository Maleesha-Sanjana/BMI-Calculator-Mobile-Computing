package edu.cinec.bmicalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.TipViewHolder> {

    private List<Tip> tipList;

    public TipAdapter(List<Tip> tipList) {
        this.tipList = tipList;
    }

    @NonNull
    @Override
    public TipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tip, parent, false);
        return new TipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipViewHolder holder, int position) {
        Tip tip = tipList.get(position);
        holder.tvTitle.setText(tip.getTitle());
        holder.tvDescription.setText(tip.getDescription());
    }

    @Override
    public int getItemCount() {
        return tipList.size();
    }

    public static class TipViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;

        public TipViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTipTitle);
            tvDescription = itemView.findViewById(R.id.tvTipDescription);
        }
    }
}
