package com.example.dorentermapp.UI.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private final TextView AssignmentItemView;
        private final TextView AssignmentItemView2;
        private AssignmentViewHolder(View itemView) {
            super(itemView);
            AssignmentItemView = itemView.findViewById(R.id.textViewAssignment);
            AssignmentItemView2 = itemView.findViewById(R.id.textViewAssignment2);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Assignments current = mAssignments.get(position);
                Intent intent = new Intent(context, AssignmentDetailsPage.class);//where you want it to go i guess
                intent.putExtra("courseid", current.getCourseID());
                intent.putExtra("date", current.getAssignmentDate());
                intent.putExtra("id", current.getAssignmentID());
                intent.putExtra("name", current.getAssignmentName());
                intent.putExtra("type", current.getAssignmentType());
                context.startActivity(intent);
            });
        }
    }

    private List<Assignments> mAssignments;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssignmentAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssignmentAdapter.AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.assignment_list_item,parent,false);
        return new AssignmentAdapter.AssignmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentAdapter.AssignmentViewHolder holder, int position) {
        if(mAssignments!=null){
            Assignments current = mAssignments.get(position);
            holder.AssignmentItemView.setText(current.getAssignmentName());
            holder.AssignmentItemView2.setText(current.getAssignmentDate());
        }
        else{
            holder.AssignmentItemView.setText("No Course Name");
            holder.AssignmentItemView2.setText("No Course Start Date");

        }
    }

    public void setAssignments(List<Assignments> assignments){
        mAssignments = assignments;
        notifyDataSetChanged();//refresh
    }


    @Override
    public int getItemCount() {
        if (mAssignments != null) {
            return mAssignments.size();
        }
        else
            return 0;
    }
}
