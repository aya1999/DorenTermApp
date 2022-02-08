package com.example.dorentermapp.UI.UI;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private AssignmentViewHolder(View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public AssignmentAdapter.AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentAdapter.AssignmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
