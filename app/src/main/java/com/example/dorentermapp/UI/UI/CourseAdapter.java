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
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    class CourseViewHolder extends  RecyclerView.ViewHolder{
        private final TextView CourseItemView;
        private final TextView CourseItemView2;
        private CourseViewHolder(View itemView) {
            super(itemView);
            CourseItemView=itemView.findViewById(R.id.textViewCourse);
            CourseItemView2=itemView.findViewById(R.id.textViewCourse2);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Courses current = mCourses.get(position);
                Intent intent = new Intent(context, CourseDetailsPage.class);//where you want it to go i guess
                intent.putExtra("id", current.getCourseID());
                intent.putExtra("name", current.getCourseTitle());
                intent.putExtra("start", current.getCourseStartDate());
                intent.putExtra("end", current.getCourseEndDate());
                intent.putExtra("status", current.getCourseStatus());
                context.startActivity(intent);
            });
        }
    }

    private List<Courses> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;


    public CourseAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item,parent,false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses!=null){
            Courses current = mCourses.get(position);
            holder.CourseItemView.setText(current.getCourseTitle());
            holder.CourseItemView2.setText(current.getCourseStartDate());
        }
        else{
            holder.CourseItemView.setText("No Course Name");
            holder.CourseItemView2.setText("No Course Start Date");

        }

    }

    public void setCourses(List<Courses> courses){
        mCourses = courses;
        notifyDataSetChanged();//refresh
    }

    @Override
    public int getItemCount() {
        if (mCourses != null) {
            return mCourses.size();
        }
        else
            return 0;
    }

}
