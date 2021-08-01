package com.example.e_commerce.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.R;
import com.example.e_commerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull

    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull  CourseAdapter.CourseViewHolder holder, int position) {
        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());
        holder.courseLinearLayout.setBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder{

        TextView courseTitle, courseLevel, courseDate;
        ImageView courseImage;
        LinearLayout courseLinearLayout;

        public CourseViewHolder(@NonNull  View itemView) {
            super(itemView);
            courseDate = itemView.findViewById(R.id.tv_course_date);
            courseLevel = itemView.findViewById(R.id.tv_course_level);
            courseTitle = itemView.findViewById(R.id.tv_course_title);
            courseImage = itemView.findViewById(R.id.iv_course);
            courseLinearLayout = itemView.findViewById(R.id.ll_course);

        }
    }
}
